# Rick And Morty Test
## _Rick Morty Application_

Estimados, para la ejecucion de las pruebas deben usar la siguiente URL:
- http://190.242.40.205:8080/RickMortyApp

Este es un servidor publico que tenemos para los desarrollos en la compañia pero no es un AWS o AzuerCloud.
La aplicacion corre dentro de un Servidor de Aplicaciones PAYARA Server.

Para las pruebas utilizo el SOAP UI no es tan moderno pero me funciona perfectametne.

## Punto 1
- Se debe de enviar una peticion como la siguiente:
```sh
(Url : (GET) http://190.242.40.205:8080/RickMortyApp/episode/customDetail/28)
{
	"numbers": [
		{"number" : 10},
		{"number" : 11},
		{"number" : 12}
	]
}
```
- La salida es la siguiente:
```sh
{
   "episode": 28,
   "episodeName": "Episode 28",
   "characters":    [
            {
         "name": "Rick",
         "species": "Human",
         "gender": "Male",
         "image": "Image1.jpg",
         "location":          {
            "id": 1,
            "type": "Earth",
            "dimension": "Planet"
         }
      },
            {
         "name": "Morty",
         "species": "Human",
         "gender": "Male",
         "image": "Image1.jpg",
         "location":          {
            "id": 1,
            "type": "Earth",
            "dimension": "Planet"
         }
      }
   ]
}
```
- Imagen SOAP UI de Referencia:
https://drive.google.com/file/d/1qy2xweusRslXbC7_PuL3KI8GnR4DjWbP/view?usp=sharing
## Punto 2
- Estas son las referencias a las APIs creadas

| Resource | Input | Method |
| ------ | ------ | ------ |
| /episode/create | @RequestBody (com.rickmorty.api.model.entity.Episode) | **POST** |
| /episode/customDetail/{id} | @PathVariable | **GET** |
| /episode/details/{id} | @PathVariable | **GET** |
| /episode/all |  | **GET** |
| /episode/update/{id} |  @PathVariable, @RequestBody (com.rickmorty.api.model.entity.Episode) | **PUT** |
| /episode/delete/{id} | @PathVariable | **DELETE** |

| Resource | Input | Method |
| ------ | ------ | ------ |
| /character/create | @RequestBody (com.rickmorty.api.model.entity.Character) | **POST** |
| /character/customDetail/{id} | @PathVariable | **GET** |
| /character/details/{id} | @PathVariable | **GET** |
| /character/all |  | **GET** |
| /character/update/{id} |  @PathVariable, @RequestBody (com.rickmorty.api.model.entity.Character) | **PUT** |
| /character/delete/{id} | @PathVariable | **DELETE** |

## Punto 3
- Se debe de enviar un json como el siguiente:
```sh
(Url : (POST) http://190.242.40.205:8080/RickMortyApp/utils/happynumbers)
{
	"numbers": [
		{"number" : 10},
		{"number" : 11},
		{"number" : 12}
	]
}
```
- La salida es la siguiente:
```sh
{"numbers": [
      {
      "number": 10,
      "happy": true
   },
      {
      "number": 11,
      "happy": false
   },
      {
      "number": 12,
      "happy": false
   }
]}
```
- Imagen SOAP UI de Referencia:
https://drive.google.com/file/d/1fkDraTCa_FzJn8Gxo4i_pYJgHKcp2qAD/view?usp=sharing

## Punto 4
- Se debe de enviar una peticion como la **siguiente**:
```sh
(Url : (POST) http://190.242.40.205:8080/RickMortyApp/utils/calculateSum/20
```
- La salida es la siguiente:
```sh
{"result": 210}
```
- Imagen SOAP UI de Referencia:
https://drive.google.com/file/d/1joIC-CCuGEzm4wfGevajjEKFhjkSwvXj/view?usp=sharing

## License
  **David Santiago Bermudez Sabagh, 2021**
  
[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
