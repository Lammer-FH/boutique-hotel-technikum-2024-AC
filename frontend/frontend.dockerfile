# frontend/frontend.Dockerfile

FROM node:20

WORKDIR /app

COPY /package*.json ./

RUN npm install
RUN npm install -g @ionic/cli

COPY . .
EXPOSE 8100
#--host 0.0.0.0 to make the port also available on the host where the container is running
CMD ["ionic","serve","--host","0.0.0.0"]
