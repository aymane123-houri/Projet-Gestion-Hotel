from flask import Blueprint, request, jsonify
from extensions import db
from entities.Chambre import Chambre

chambre_routes = Blueprint('chambre_routes', __name__)

@chambre_routes.route('/chambres', methods=['POST'])
def add_chambre():
    data = request.json
    try:
        new_chambre = Chambre(
            numero=data['numero'],
            type_chambre=data['type_chambre'],
            prix=data['prix'],
            disponible=data.get('disponible', True)
        )
        db.session.add(new_chambre)
        db.session.commit()
        return jsonify(new_chambre.to_dict()), 201
    except Exception as e:
        db.session.rollback()
        return jsonify({"message": f"Erreur : {str(e)}"}), 400

@chambre_routes.route('/chambres', methods=['GET'])
def get_chambres():
    chambres = Chambre.query.all()
    return jsonify([chambre.to_dict() for chambre in chambres])

@chambre_routes.route('/chambres/<int:id>', methods=['GET'])
def get_chambre(id):
    chambre = Chambre.query.get(id)
    if chambre:
        return jsonify(chambre.to_dict())
    return jsonify({"message": "Chambre introuvable"}), 404


@chambre_routes.route('/chambres/<int:id>', methods=['PUT'])
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
        if 'type_chambre' in data:
            chambre.type_chambre = data['type_chambre']
        if 'prix' in data:
            chambre.prix = data['prix']
        if 'disponible' in data:
            chambre.disponible = data['disponible']

        db.session.commit()
        return jsonify(chambre.to_dict()), 200
    except Exception as e:
        db.session.rollback()
        return jsonify({"message": f"Erreur lors de la mise à jour : {str(e)}"}), 400


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
