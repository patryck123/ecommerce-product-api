# 🛒 E-commerce Product API

Catálogo de produtos para e-commerce com categorias, estoque e SKU único.

## 📋 Sobre o Projeto

API de catálogo de produtos para lojas virtuais. Cada produto tem categorias, código SKU único, controle de estoque, preço e status de disponibilidade. Suporta busca por nome e filtragem por categoria.

## ✨ Funcionalidades

- ✅ Cadastrar produtos com SKU único
- ✅ Organizar por categorias hierárquicas
- ✅ Controle de estoque por produto
- ✅ Busca de produtos por nome (busca parcial)
- ✅ Filtrar por categoria
- ✅ Filtrar por disponibilidade (em estoque)
- ✅ Atualizar preço e quantidade em estoque
- ✅ Ativar/desativar produto

## 🔗 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| GET/POST | `/api/products` | Listar / Cadastrar produto |
| GET/PUT/DELETE | `/api/products/{id}` | Gerenciar produto |
| GET | `/api/products/search?name=camiseta` | Buscar por nome |
| GET | `/api/products/category/{id}` | Filtrar por categoria |
| GET/POST | `/api/categories` | Gerenciar categorias |

## 🛠️ Tecnologias

- Java 17 · Spring Boot 3.2 · PostgreSQL · Maven · Lombok
