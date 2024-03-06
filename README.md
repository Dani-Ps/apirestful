# API DE PRODUCTOS - PROYECTO FINAL
> ### Profesor - Juan Pablo Domínguez Mayo
>  > [Pefil de Github](https://github.com/profeInformatica101)
> ### Alumno - Daniel Perez Serrano 
>  > [Pefil de Github](https://github.com/Dani-Ps)

## Índice de anotaciones.

> [!NOTE]
> Para el manual de despliegue.

> [!TIP]
> Para consejos claves.

> [!IMPORTANT]
> Para avisos importantes.

>[!WARNING]
> Para prestar atención en ese paso concreto.

> [!CAUTION]
> Para tener precaución en un punto concreto.

## DOCUMENTACION DE LA API:

> [!NOTE]
> Si quieres ver y probar la API, lanzala y entrar en la documentación de swagger.
> ```bash
> http://localhost:8080/api/v1/productos/swagger-ui.html
> ```

### Resultado esperado: 
![image](https://github.com/Dani-Ps/apirestful/assets/117571463/b93d369d-1e11-47f1-b906-6fa914101fff)

## Documentación de Postam: 

> ## SIGNIN
[`http://localhost:8080/api/v1/auth/signin`](http://localhost:8080/api/v1/auth/signin)

This endpoint allows users to sign in and obtain an authentication token. The HTTP POST request should be made to [http://localhost:8080/api/v1/auth/signin](http://localhost:8080/api/v1/auth/signin) with the raw request body containing the user's email and password.

### Request Body

- email (text, required): The email of the user.
- password (text, required): The password of the user.
    

### Response

Upon successful authentication, the server will respond with a status code of 200 and a JSON object containing the authentication token.

Example Response:

``` json
{
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}

 ```

> ##  READ-ALL
[`http://localhost:8080/api/v1/productos/{ID}`
](http://localhost:8080/api/v1/productos/)

This endpoint allows you to create a new product by making an HTTP POST request to the specified URL. Upon successful execution, the server responds with a status code of 200 and a JSON object containing information about the newly created product. The response includes an array of products with their respective IDs, codes, names, and prices, along with pagination details such as page number, page size, and sorting information.
Example Response:

``` json
{
  "content": [
    {
      "id": 0,
      "codigo": "",
      "nombre": "",
      "precio": 0
    }
  ],
  "pageable": {
    "pageNumber": 0,
    "pageSize": 0,
    "sort": {
      "sorted": true,
      "unsorted": true,
      "empty": true
    },
    "offset": 0,
    "unpaged": true,
    "paged": true
  },
  "last": true,
  "totalPages": 0,
  "totalElements": 0,
  "first": true,
  "numberOfElements": 0,
  "size": 0,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": true,
    "empty": true
  },
  "empty": true
}

 ```

> ##  READ-ID

[`http://localhost:8080/api/v1/productos/{ID}`](http://localhost:8080/api/v1/productos/284)

This endpoint retrieves the details of a specific product with the ID 274.

### Request

`GET /api/v1/productos/274`

### Response

- Status: 200
- Content-Type: application/json
    

``` json
{
    "id": 274,
    "codigo": "4774377139",
    "nombre": "Practical Leather Knife",
    "precio": 256.42
}
 ```

> ##  CREATE

`http://localhost:8080/api/v1/productos/add`
This API endpoint allows you to add a new product to the system. When making a POST request to the specified URL, you should include the product details in the request body.

### Request Body

- `codigo` (string): The product code.
- `nombre` (string): The name of the product.
- `precio` (number): The price of the product.
    

### Response

Upon a successful execution, the API will return a JSON object with the following fields:

- `id` (number): The unique identifier of the newly added product.
- `codigo` (string): The product code.
- `nombre` (string): The name of the product.
- `precio` (number): The price of the product.
    

Example:

``` json
{
  "id": 123,
  "codigo": "ABC123",
  "nombre": "Product Name",
  "precio": 50.00
}

 ```
> ##  UPDATE

[`http://localhost:8080/api/v1/productos/{ID}`](http://localhost:8080/api/v1/productos/284)

This API endpoint allows you to update a specific product with the given ID. The HTTP PUT request should be made to [http://localhost:8080/api/v1/productos/275](http://localhost:8080/api/v1/productos/275) with a JSON payload in the request body. The payload should include the fields "codigo", "nombre", and "precio" to update the product details.

### Request Body

- codigo (string): The product code.
- nombre (string): The name of the product.
- precio (number): The price of the product.
    

### Response

Upon a successful update, the API will return a status code of 200 with a JSON response containing the updated product details, including the "id", "codigo", "nombre", and "precio" fields.

Example:

``` json
{
    "id": 0,
    "codigo": "",
    "nombre": "",
    "precio": 0
}

 ```

> ##  DELETE
[`http://localhost:8080/api/v1/productos/{ID}`](http://localhost:8080/api/v1/productos/284)
### Delete Product

This endpoint sends an HTTP DELETE request to delete a specific product with the ID 284.

#### Response

- Status: 200
- Content-Type: text/xml
- Body: null
