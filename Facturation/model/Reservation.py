
class Reservation:
    def getReservation(date_debut, date_fin, montant_total,
                       nom, prenom, email, telephone, adresse, cni,
                       numero, prix):

        user_data = {
            "nom": nom,
            "prenom": prenom,
            "email": email,
            "telephone": telephone,
            "adresse": adresse,
            "cni": cni
        }

        chambre_data = {
            "numero": numero,
            "prix": prix,
        }

        reservation_data = {
            "date_debut": date_debut,
            "date_fin": date_fin,
            "montant_total": montant_total,
            "user": user_data,
            "chambre": chambre_data
        }
        return reservation_data
