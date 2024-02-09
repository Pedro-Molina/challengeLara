## Endpoint: http://localhost:8081/conversation/employee-answer
### Método: POST

Esta API recibe la respuesta de un empleado a una pregunta de una conversación en curso.

#### Parámetros de entrada:
- `employeeAnswer` (RequestBody): Un objeto JSON que contiene la respuesta del empleado.
  - `data`: Objeto que contiene la información de la respuesta del empleado.
    - `employeeId` (String): El ID del empleado que envía la respuesta.
    - `answer` (String): La respuesta proporcionada por el empleado.
    - `context` (Map<String, String>): Un mapa que contiene el contexto de la conversación.
      - `conversationId` (String): El ID de la conversación a la que pertenece la pregunta respondida.
      - `questionId` (String): El ID de la pregunta que fue respondida.

#### Respuesta:
- Código de estado HTTP: 200 OK
- Cuerpo de la respuesta: "OK"


## Endpoint: http://localhost:8081/conversation/create-conversation
### Método: POST

Esta API crea una nueva conversación y envía la primera pregunta al empleado.

#### Parámetros de entrada:
- `initConversationBody` (RequestBody): Un objeto JSON que contiene la información necesaria para iniciar una nueva conversación.
  - `employeeId` (String): El ID del empleado para el que se crea la conversación.
  - `questionsId` (List<String>): Una lista de IDs de las preguntas que formarán parte de la conversación.

#### Ejemplo:
```json
{
  "employeeId": "123456789",
  "questionsId": ["1", "2", "3"]
}
```

#### Respuesta:
- Código de estado HTTP: 200 OK
- Cuerpo de la respuesta: Un objeto JSON que contiene un mensaje de confirmación.
  - `message` (String): Mensaje indicando si la creación de la conversación fue exitosa o si hubo algún error.

##### Ejemplo de respuesta exitosa:
```json
{
  "message": "Creacion de conversacion exitosa"
}
```

##### Ejemplo de respuesta con error:
```json
{
  "message": "Una de las preguntas enviadas no existe"
}
```
