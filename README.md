# 🎨 Design Patterns & Principles Examples

![Java](https://img.shields.io/badge/Java-8%2B-ED8936?style=for-the-badge&logo=openjdk)
![Maven](https://img.shields.io/badge/Maven-3.6%2B-C71A36?style=for-the-badge&logo=apache-maven)
![Gradle](https://img.shields.io/badge/Gradle-Latest-02303A?style=for-the-badge&logo=gradle)
![JUnit](https://img.shields.io/badge/JUnit-5-25A162?style=for-the-badge&logo=junit5)
![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)

> Uma coleção completa e prática de exemplos de **Design Patterns** e **Princípios SOLID** implementados em Java, com casos de uso reais e testes unitários.

## 📖 Sobre o Projeto

Este repositório contém implementações de padrões de projeto clássicos (Gang of Four) e princípios SOLID, organizados de forma didática e profissional. Cada padrão possui exemplos práticos com casos de uso reais, facilitando o aprendizado e a aplicação em projetos.

---

## 📋 Padrões Implementados

### 🏗️ Padrões Criacionais

| Padrão | Descrição | Local |
|--------|-----------|-------|
| **Abstract Factory** | Criar famílias de objetos relacionados sem especificar suas classes concretas | [`AbstractFactory/`](AbstractFactory/) |
| **Factory** | Criar objetos sem especificar exatamente qual classe será instanciada | [`Factory/`](Factory/) |
| **Factory Method** | Criar objetos por meio de um método em vez de chamadas diretas ao construtor | [`FactoryMethod/`](FactoryMethod/) |
| **Singleton** | Garantir que uma classe tenha apenas uma instância e fornecer acesso global a ela | [`Singleton/`](Singleton/) |
| **Builder** | Separar a construção de um objeto complexo de sua representação | [`Builder/`](Builder/) |
| **Prototype** | Criar novos objetos copiando um objeto existente (protótipo) | [`prototype/`](prototype/) |

### 🔄 Padrões Estruturais

| Padrão | Descrição | Local |
|--------|-----------|-------|
| **Adapter** | Converter a interface de uma classe em outra esperada pelos clientes | [`Adapter/`](Adapter/) |
| **Bridge** | Desacoplar uma abstração de sua implementação | [`Bridge/`](Bridge/) |
| **Decorator** | Adicionar responsabilidades a um objeto dinamicamente | [`Decorator/`](Decorator/) |
| **Facade** | Fornecer uma interface unificada para um conjunto de interfaces | [`Facade/`](Facade/) |
| **Proxy** | Fornecer um substituto ou marcador para controlar acesso a outro objeto | [`Proxy/`](Proxy/) |

### 🎯 Padrões Comportamentais

| Padrão | Descrição | Local |
|--------|-----------|-------|
| **Observer** | Definir uma dependência um-para-muitos entre objetos | [`Observer/`](Observer/) |
| **Command** | Encapsular um pedido como um objeto | [`Command/`](Command/) |
| **State** | Permitir que um objeto altere seu comportamento quando seu estado muda | [`State/`](State/) |
| **Strategy** | Definir uma família de algoritmos e deixá-los intercambiáveis | [`Strategy/`](Strategy/) |
| **Chain of Responsibility** | Passar um pedido ao longo de uma cadeia de objetos | [`ChainOfRepository/`](ChainOfRepository/) |
| **Memento** | Capturar e externalizar o estado interno de um objeto | [`Memento/`](Memento/) |
| **Template Method** | Definir o esqueleto de um algoritmo em uma classe base | [`TemplatMethod/`](TemplatMethod/) |

### 💎 Princípios SOLID

| Princípio | Descrição | Local |
|-----------|-----------|-------|
| **SRP** | Single Responsibility Principle | [`SOLID/`](SOLID/) |
| **OCP** | Open/Closed Principle | [`SOLID/`](SOLID/) |
| **LSP** | Liskov Substitution Principle | [`SOLID/LSP/`](SOLID/LSP/) |
| **ISP** | Interface Segregation Principle | [`SOLID/ICP/`](SOLID/ICP/) |
| **DIP** | Dependency Inversion Principle | [`SOLID/`](SOLID/) |

### 🔍 Outros Conceitos

- **MVC** - Padrão Model-View-Controller
- **Tell, Don't Ask** - Princípio de Design
- **Null Object** - Padrão de comportamento

---

## 🚀 Quick Start

### Pré-requisitos

- **Java**: JDK 8+ (recomendado JDK 11 ou superior)
- **Build Tool**: Maven 3.6+ ou Gradle 6.0+
- **Git**: Para clonar o repositório

### Instalação

```bash
# Clone o repositório
git clone <seu-repositorio>
cd DesignPatternsAndPrinciplesExamples

# Navegue até um padrão específico
cd Builder/builder

# Compile o projeto
mvn clean compile  # Para projetos Maven
# ou
gradle build       # Para projetos Gradle
```

### Executando os Testes

```bash
# Todos os testes
mvn test
# ou
gradle test

# Teste específico
mvn test -Dtest=SuaClasseDeTesteTest
```

---

## 📁 Estrutura do Projeto

```
DesignPatternsAndPrinciplesExamples/
├── AbstractFactory/          # Padrão Abstract Factory
├── Adapter/                  # Padrão Adapter
├── Bridge/                   # Padrão Bridge
├── Builder/                  # Padrão Builder
├── ChainOfRepository/        # Padrão Chain of Responsibility
├── Command/                  # Padrão Command
├── Decorator/                # Padrão Decorator
├── Facade/                   # Padrão Facade
├── Factory/                  # Padrão Factory
├── FactoryMethod/            # Padrão Factory Method
├── Memento/                  # Padrão Memento
├── NullObject/               # Padrão Null Object
├── Observer/                 # Padrão Observer
├── OutrosConceitos/          # Outros conceitos (MVC, Tell Don't Ask)
├── Proxy/                    # Padrão Proxy
├── Singleton/                # Padrão Singleton
├── SOLID/                    # Princípios SOLID
├── State/                    # Padrão State
├── Strategy/                 # Padrão Strategy
├── TemplatMethod/            # Padrão Template Method
└── prototype/                # Padrão Prototype
```

### Características de Cada Projeto

✅ **Implementação clara** - Código bem estruturado e comentado  
✅ **Testes unitários** - Exemplos com JUnit para validação  
✅ **Build automático** - Maven ou Gradle configurados  
✅ **Casos práticos** - Exemplos baseados em cenários reais  
✅ **Fácil de entender** - Nomes descritivos e padrão consistente  

---

## 💻 Tecnologias Utilizadas

| Tecnologia | Versão | Uso |
|------------|--------|-----|
| **Java** | 8+ | Linguagem principal |
| **Maven** | 3.6+ | Gerenciamento de build |
| **Gradle** | 6.0+ | Gerenciamento de build |
| **JUnit** | 4/5 | Framework de testes |
| **Spring Boot** | 2.3+ | Em alguns exemplos |

---

## 📚 Como Usar Este Repositório

1. **Explorar um padrão específico**: Navegue até a pasta do padrão desejado
2. **Entender a implementação**: Leia o código comentado
3. **Executar os testes**: Validar o comportamento do padrão
4. **Adaptar para seu projeto**: Use como referência

Cada padrão é **independente** e pode ser estudado isoladamente.

---

## 🎓 Recuros Recomendados

- Design Patterns: Elements of Reusable Object-Oriented Software (Gang of Four)
- Refactoring: Improving the Design of Existing Code
- Clean Code: A Handbook of Agile Software Craftsmanship
- Design Patterns in Java by Steven J. Metsker

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:
- Melhorar exemplos existentes
- Adicionar novos casos de uso
- Corrigir bugs ou melhorar a documentação
- Adicionar mais padrões

---

## 📝 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo [LICENSE](LICENSE) para detalhes.

---

## 👨‍💻 Autor

**Daniel Smanioto**

Compartilhando conhecimento sobre Design Patterns e boas práticas em desenvolvimento.

---

## 📞 Suporte

Se tiver dúvidas ou sugestões sobre os padrões, sinta-se livre para abrir uma **Issue** no repositório.

---

<div align="center">

⭐ Se este repositório foi útil para você, considere dar uma estrela! ⭐

</div>
  

