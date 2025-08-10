# 🏥 MedCenter

**MedCenter** é uma API desenvolvida em Java com Spring Boot para gerenciamento de informações médicas, incluindo autenticação, consultas, clientes, médicos, entre outros.

---

## 📂 Estrutura do Projeto

```
MedCenter/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── medcenter/
│   │   │           ├── controller/
│   │   │           │   ├── AuthController.java
│   │   │           │   ├── PatientController.java
│   │   │           │   ├── ConsultationController.java
│   │   │           │   └── DoctorController.java
│   │   │           │
│   │   │           ├── domain/
│   │   │           │   ├── Patient.java
│   │   │           │   ├── Consultation.java
│   │   │           │   ├── Doctor.java
│   │   │           │   └── Address.java
│   │   │           │
│   │   │           ├── service/
│   │   │           ├── repository/
│   │   │           ├── exception/
│   │   │           ├── security/
│   │   │           └── config/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       └── ...
│
│   └── test/
│       └── java/
│           └── com/
│               └── medcenter/
│                   └── ...
│
└── pom.xml
```

---

## 🚀 Tecnologias Utilizadas

- 💻 **Linguagem:** Java  
- ⚙️ **Framework:** Spring Boot  
- 🔒 **Segurança:** Spring Security com JWT  
- 🗄️ **Banco de Dados:** MySQL  
- 🛠️ **Build:** Maven  
- 📦 **Dependências:** Lombok, Validation  

---

## ⚙️ Configuração do Projeto

1. Clone o repositório:  
   ```bash
   git clone <URL-do-repositório>
   ```

2. Acesse o diretório do projeto:  
   ```bash
   cd MedCenter
   ```

3. Compile e execute a aplicação:  
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

---

## 📡 Endpoints Principais

| Recurso        | Endpoint             | Descrição                        |
| -------------- | -------------------- | ------------------------------- |
| 🔐 Autenticação | `/api/auth`          | Login e gerenciamento de tokens |
| 👤 Clientes    | `/api/patients`      | CRUD de pacientes               |
| 📅 Consultas   | `/api/consultations` | Agendamento e gerenciamento     |
| 👨‍⚕️ Médicos     | `/api/doctors`       | Gerenciamento de médicos        |

---

## 🤝 Como Contribuir

1. Faça um fork do projeto.  
2. Crie uma branch para sua feature:  
   ```bash
   git checkout -b minha-feature
   ```  
3. Faça commit das suas alterações:  
   ```bash
   git commit -m "Descrição da feature"
   ```  
4. Envie para o repositório remoto:  
   ```bash
   git push origin minha-feature
   ```  
5. Abra um pull request para revisão.  

---

## 📄 Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

---
