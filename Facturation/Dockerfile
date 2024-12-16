# Utiliser une image Python officielle comme base
FROM python:3.9-slim

# Définir un répertoire de travail dans le conteneur
WORKDIR /app

# Copier les fichiers de votre application dans le conteneur
COPY . /app

# Installer les dépendances Python
RUN pip install --no-cache-dir -r requirements.txt

# Définir la commande par défaut pour exécuter l'application
CMD ["python", "FactureServiceApp.py"]
