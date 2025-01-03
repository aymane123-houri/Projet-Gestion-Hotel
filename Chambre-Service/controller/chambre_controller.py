import base64
import binascii
import os

from flask import Blueprint, request, jsonify
from extensions import db
from entities.Chambre import Chambre

chambre_routes = Blueprint('chambre_routes', __name__)


''''@chambre_routes.route('/chambres', methods=['POST'])
def add_chambre():
    data = request.json

    # Get the image file path from the request data
    image_path = data['image']

    # Check if the file exists
    if not os.path.exists(image_path):
        return jsonify({"error": "File not found"}), 400

    # Open and read the image as binary data
    with open(image_path, 'rb') as image_file:
        image_data = image_file.read()

    try:
        new_chambre = Chambre(
            numero=data['numero'],
            nombre_lits=data['nombre_lits'],
            prix=data['prix'],
            image=image_data,
            description=data['description'],
            disponible=data.get('disponible', True)
        )

        chambre_dict = new_chambre.to_dict()
        chambre_dict['image'] = base64.b64encode(new_chambre.image).decode('utf-8')

        db.session.add(new_chambre)
        db.session.commit()

        return jsonify(chambre_dict), 201

    except Exception as e:
        db.session.rollback()
        return jsonify({"message": f"Erreur : {str(e)}"}), 400
'''

import base64
import os

chambre_routes = Blueprint('chambre_routes', __name__)

@chambre_routes.route('/chambres', methods=['POST'])
def add_chambre():
    data = request.json

    # Log des données reçues
    print("Données reçues :", data)

    # Vérifiez si l'image encodée est présente
    image_base64 = data.get('image')
    if not image_base64:
        return jsonify({"error": "Image data is missing"}), 400

    try:
        # Décodage de l'image Base64 en données binaires
        image_data = base64.b64decode(image_base64)

        # Log après décodage
        print("Image décodée avec succès")

        # Création de l'objet Chambre
        new_chambre = Chambre(
            numero=data['numero'],
            nombre_lits=data['nombre_lits'],
            prix=data['prix'],
            image=image_data,
            description=data['description'],
            disponible=data.get('disponible', True),
            adulte_capacite=data.get('adulte_capacite'),
            enfant_capacite=data.get('enfant_capacite'),
            type_lits=data.get('type_lits'),
        )

        # Ajout à la base de données
        db.session.add(new_chambre)
        db.session.commit()

        # Préparer la réponse JSON avec l'image encodée pour affichage éventuel
        chambre_dict = new_chambre.to_dict()
        chambre_dict['image'] = image_base64

        print("Chambre ajoutée avec succès :", chambre_dict)

        return jsonify(chambre_dict), 201

    except Exception as e:
        db.session.rollback()
        print("Erreur :", str(e))  # Log des erreurs
        return jsonify({"message": f"Erreur : {str(e)}"}), 400


@chambre_routes.route('/chambres', methods=['GET'])
def get_chambres():
    chambres = Chambre.query.all()
    chambres_data = []

    for chambre in chambres:
        chambre_dict = chambre.to_dict()  # Get the chambre data as a dict
        if chambre.image:  # Check if the chambre has an image
            chambre_dict['image'] = base64.b64encode(chambre.image).decode('utf-8')  # Convert image to base64
        else:
            chambre_dict['image'] = None  # Handle the case where there's no image
        chambres_data.append(chambre_dict)

    return jsonify(chambres_data)


@chambre_routes.route('/chambres/<int:id>', methods=['GET'])
def get_chambre(id):
    chambre = Chambre.query.get(id)
    if chambre:
        return jsonify(chambre.to_dict())
    return jsonify({"message": "Chambre introuvable"}), 404


'''''@chambre_routes.route('/chambres/<int:id>', methods=['PUT'])
def update_chambre(id):
    """
    Met à jour les détails d'une chambre existante.
    """
    data = request.json
    chambre = Chambre.query.get(id)

    if not chambre:
        return jsonify({"message": "Chambre introuvable"}), 404

    try:
        # Met à jour les champs fournis dans le JSON
        if 'numero' in data:
            chambre.numero = data['numero']
        if 'nombre_lits' in data:
            chambre.nombre_lits = data['nombre_lits']
        if 'prix' in data:
            chambre.prix = data['prix']
        if 'image' in data:
            # Get the image file path from the request data
            image_path = data['image']

            # Check if the file exists
            if not os.path.exists(image_path):
                return jsonify({"error": "File not found"}), 400

            # Open and read the image as binary data
            with open(image_path, 'rb') as image_file:
                image_data = image_file.read()

            chambre.image = image_data
        if 'description' in data:
            chambre.description = data['description']
        if 'disponible' in data:
            chambre.disponible = data['disponible']

        db.session.commit()

        chambre_dict = chambre.to_dict()
        chambre_dict['image'] = base64.b64encode(chambre.image).decode('utf-8')

        return jsonify(chambre_dict), 200
    except Exception as e:
        db.session.rollback()
        return jsonify({"message": f"Erreur lors de la mise à jour : {str(e)}"}), 400
'''


@chambre_routes.route('/chambres/<int:id>', methods=['PUT'])
def update_chambre(id):
    data = request.json  # Récupère les données JSON envoyées dans la requête

    # Trouver la chambre à modifier dans la base de données
    chambre = Chambre.query.get(id)
    if not chambre:
        return jsonify({"error": "Chambre not found"}), 404

    # Mettre à jour les autres champs
    chambre.numero = data.get('numero', chambre.numero)
    chambre.nombre_lits = data.get('nombre_lits', chambre.nombre_lits)
    chambre.prix = data.get('prix', chambre.prix)
    chambre.description = data.get('description', chambre.description)
    chambre.disponible = data.get('disponible', chambre.disponible)
    chambre.adulte_capacite = data.get('adulte_capacite', chambre.adulte_capacite)
    chambre.enfant_capacite = data.get('enfant_capacite', chambre.enfant_capacite)
    chambre.type_lits = data.get('type_lits', chambre.type_lits)


    # Vérifier si une nouvelle image est envoyée, sinon conserver l'ancienne
    image_base64 = data.get('image')
    if image_base64:
        # Décoder l'image Base64 en données binaires
        chambre.image = base64.b64decode(image_base64)

    try:
        db.session.commit()  # Sauvegarde les modifications dans la base de données
        chambre_dict = chambre.to_dict()  # Convertit l'objet Chambre en dictionnaire pour la réponse
        chambre_dict['image'] = base64.b64encode(chambre.image).decode('utf-8')  # Encode à nouveau l'image en base64
        return jsonify(chambre_dict), 200  # Retourne la chambre modifiée

    except Exception as e:
        db.session.rollback()  # Annule les changements en cas d'erreur
        return jsonify({"error": f"Erreur : {str(e)}"}), 400


@chambre_routes.route('/chambres/<int:id>', methods=['DELETE'])
def delete_chambre(id):
    """
    Supprime une chambre existante par son ID.
    """
    chambre = Chambre.query.get(id)
    if not chambre:
        return jsonify({"message": "Chambre introuvable"}), 404

    try:
        db.session.delete(chambre)
        db.session.commit()
        return jsonify({"message": f"Chambre avec ID {id} supprimée avec succès"}), 200
    except Exception as e:
        db.session.rollback()
        return jsonify({"message": f"Erreur lors de la suppression : {str(e)}"}), 400


@chambre_routes.route('/chambres/search', methods=['GET'])
def search_chambres():
    type_chambre = request.args.get('type_chambre')
    disponible = request.args.get('disponible')
    prix_min = request.args.get('prix_min', type=float)
    prix_max = request.args.get('prix_max', type=float)

    query = Chambre.query

    if type_chambre:
        query = query.filter(Chambre.type_chambre == type_chambre)
    if disponible is not None:
        query = query.filter(Chambre.disponible == (disponible.lower() == 'true'))
    if prix_min:
        query = query.filter(Chambre.prix >= prix_min)
    if prix_max:
        query = query.filter(Chambre.prix <= prix_max)

    chambres = query.all()
    return jsonify([chambre.to_dict() for chambre in chambres])


@chambre_routes.route('/chambres/<int:id>/disponible', methods=['GET'])
def check_disponible(id):
    chambre = Chambre.query.get(id)
    if chambre:
        return jsonify({"disponible": chambre.disponible})
    return jsonify({"message": "Chambre introuvable"}), 404


@chambre_routes.route('/chambres/count', methods=['GET'])
def get_chambre_count():
    count = Chambre.query.count()
    return jsonify({"total_chambres": count})


@chambre_routes.route('/chambres/<int:id>', methods=['PATCH'])
def partial_update_chambre(id):
    chambre = Chambre.query.get(id)
    if not chambre:
        return jsonify({"message": "Chambre introuvable"}), 404

    data = request.json
    if 'prix' in data:
        chambre.prix = data['prix']
    if 'disponible' in data:
        chambre.disponible = data['disponible']

    db.session.commit()
    return jsonify(chambre.to_dict())


