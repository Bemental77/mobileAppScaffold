<?php
// Simple PHP microservice demonstrating a REST endpoint and a SOAP client example.
// Run: php -S localhost:8081 -t php/api
// Visit: http://localhost:8081/rest/greet?name=PHP

$uri = parse_url($_SERVER['REQUEST_URI'], PHP_URL_PATH);

header('Content-Type: application/json');

if (preg_match('#^/rest/greet$#', $uri)) {
    $name = $_GET['name'] ?? 'php';
    echo json_encode(['message' => "Hello, $name from PHP REST!"]);
    exit;
}

// Example SOAP client usage (calls Java SOAP Calculator service on localhost)
if (preg_match('#^/soap/calc$#', $uri)) {
    $location = 'http://localhost:8080/ws/Calculator';
    $uri_ns = 'http://soap.example.com/';
    try {
        $client = new SoapClient(null, [
            'location' => $location,
            'uri' => $uri_ns,
            'trace' => 1,
            'exceptions' => 1
        ]);
        // Some JAX-WS bindings accept parameters as positional array
        $result = $client->__soapCall('add', [4, 5]);
        echo json_encode(['result' => $result]);
    } catch (Exception $e) {
        http_response_code(500);
        echo json_encode(['error' => $e->getMessage()]);
    }
    exit;
}

http_response_code(404);
echo json_encode(['error' => 'Not found']);