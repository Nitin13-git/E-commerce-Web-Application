# E-commerce Web Application

A modern e-commerce web application built with Spring Boot.

## Features

- **Product Management**
  - Browse and search products
  - View product details
  - Create, update, and delete products
  - Product categorization and filtering

- **Order Management**
  - Create and track orders
  - Order history and status updates


## Tech Stack

- **Backend**
  - Spring Boot 3.x
  - Spring AI (for AI integration)
  - Spring Data JPA
  - MySQL Database
  - Maven (Dependency Management)


## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.8 or higher
- MySQL 8.0 or higher
- OpenAI API key or Anthropic API key

### Installation


1. Clone the repository:
   ```bash
   https://github.com/Nitin13-git/E-commerce-Web-Application.git
   cd ecommerce-webapp
   ```

2. Configure the database:
   - Create a MySQL database named `ecommerce`
   - Update `application.properties` with your database credentials



3. Build the application:
   ```bash
   mvn clean install
   ```

4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## API Documentation

### Product Endpoints

- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product
- `GET /api/products/search` - Search products

### Order Endpoints

- `GET /api/orders` - Get all orders
- `GET /api/orders/{id}` - Get order by ID
- `POST /api/orders` - Create new order
- `PUT /api/orders/{id}` - Update order
- `DELETE /api/orders/{id}` - Delete order

### AI Chat Endpoints

- `POST /api/chat` - Process user query
- `GET /api/chat/history` - Get chat history


## Security

- JWT-based authentication
- Role-based access control
- Secure API endpoints
- Input validation and sanitization


## Error Handling

The application implements comprehensive error handling:

- Custom exception classes
- Global exception handler
- Meaningful error messages
- Logging and monitoring

## Testing

- Unit tests for services and controllers
- Integration tests for API endpoints
- AI response validation
- Database transaction tests

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Spring Framework
- MySQL
- Maven 
