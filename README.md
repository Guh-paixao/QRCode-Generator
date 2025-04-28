# QR Code Generator

Projeto desenvolvido em **Spring Boot 3** para geração de **QR Codes** personalizados, com suporte a upload no **Amazon S3**. Agora otimizado para rodar com **Docker multi-stage build**.

## 🚀 Tecnologias utilizadas
- Java 21 (Eclipse Temurin)
- Spring Boot 3.4.5
- Maven 3.9.6
- ZXing (geração de QR Codes)
- AWS SDK v2 (integração com S3)
- Docker (multi-stage)

## 📆 Funcionalidades
- Geração de QR Codes personalizados.
- Upload de QR Codes diretamente para um bucket S3.
- API REST simples e eficiente.

---

## 🛠️ Como rodar o projeto

### 1. Rodar localmente (Maven)

**Pré-requisitos:**
- Java 21 instalado.
- Maven instalado.

```bash
git clone https://github.com/Guh-paixao/QRCode-Generator.git
cd QRCode-Generator
mvn clean install
mvn spring-boot:run
```

A aplicação estará disponível em:
```
http://localhost:8080
```

---

### 2. Rodar com Docker

**Pré-requisitos:**
- Docker instalado.

#### Build da imagem
```bash
docker build -t qrcode-generator:1.0 .
```

#### Rodar o container
```bash
docker run --env-file .env -p 8080:8080 qrcode-generator:1.0
```

#### Exemplo de `.env`:
```
AWS_ACCESS_KEY_ID=seu-access-key
AWS_SECRET_ACCESS_KEY=sua-secret-key
AWS_S3_REGION=sa-east-1
AWS_S3_BUCKET_NAME=qrcode-storage-gus
```

---

## 📥 Exemplo de uso da API

### Gerar um QR Code
**Requisição:**
```bash
POST http://localhost:8080/qrcode
Content-Type: application/json

{
  "text": "https://seusite.com.br"
}
```

**Resposta esperada:**
- Link público do QR Code salvo no S3 (caso configurado).

---

## ⚙️ Configurações AWS S3

A aplicação lê variáveis de ambiente para configurar a AWS automaticamente:

| Variável | Descrição |
| :--- | :--- |
| `AWS_ACCESS_KEY_ID` | Access Key da AWS |
| `AWS_SECRET_ACCESS_KEY` | Secret Access Key da AWS |
| `AWS_S3_REGION` | Região do bucket (ex: `sa-east-1`) |
| `AWS_S3_BUCKET_NAME` | Nome do bucket S3 |

Essas variáveis podem ser passadas via `.env`, linha de comando ou configuradas diretamente no ambiente.

---

## 🧪 Testes

Para rodar os testes unitários:
```bash
mvn test
```

---

## 📄 Licença

Este projeto está licenciado sob [MIT License](LICENSE).

---

## 👨‍💻 Autor

Gustavo Paixão  
[LinkedIn](https://www.linkedin.com/in/gustavo-borges14/) • [GitHub](https://github.com/Guh-paixao)
