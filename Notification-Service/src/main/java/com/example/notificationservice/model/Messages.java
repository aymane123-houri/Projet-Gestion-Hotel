package com.example.notificationservice.model;

public class Messages {
    public String getConfirmationMessage(Reservation reservation, User user, Chambre chambre){
        return "✨Bonjour " + user.getNom() +" "+ user.getPrenom() +",\n\n"
                + "✅Nous sommes ravis de vous informer que votre réservation de la chambre n°" + chambre.getNumero() + " a été confirmée avec succès.\n\n"
                + "📅 Voici les détails de votre réservation :\n"
                + "- 🛏️ **Chambre** : n°" + chambre.getNumero() + "\n"
                + "- ⏰ **Date de début de séjour** : " + reservation.getDate_debut() + "\n"
                + "- ⏳ **Date de fin de séjour** : " + reservation.getDate_fin() + "\n\n"
                + "- ✅ **Prix a payé** : " + reservation.getMontant_total() + "DH"+ "\n\n"
                + "⚠️Nous vous rappelons que la chambre doit être libérée à la date de fin mentionnée ci-dessus. En cas de dépassement, des frais supplémentaires pourront être appliqués conformément à nos conditions générales.\n\n"
                + "💬 Si vous avez des questions ou besoin de plus d'informations, notre équipe est à votre disposition. Vous pouvez nous contacter à tout moment à l'adresse suivante : libsmart66@gmail.com.\n\n"
                + "Merci de nous avoir choisis pour votre séjour. Nous vous souhaitons une excellente expérience !\n\n"
                + "Cordialement,\n"
                + "L'équipe de Hotelier \uD83D\uDE0A";
    }



}
