# Laboratorio 5 - Pokémon App

## Descripción
Esta aplicación permite que el usuario:
- Vea una lista de 100 Pokemones
- Navegar a una pantalla de detalles para ver diferentes imágenes de cada Pokémon

## Componentes Principales
- MainActivity
- MainFragment
- DetailFragment

## Network
- RetrofitClient: cliente Retrofit configurado para consumir la PokemonAPI
- PokemonApi: interfaz que define los endpoints de la API
- Modelos de Datos:
  - Pokemon: modelo básico con nombre y URL
  - PokemonDetail: modelo detallado con sprites
  - PokemonListResponse: respuesta de la lista de Pokémon
  - Sprites: modelo para las imágenes del Pokémon

## Funcionamiento

### Pantalla de la lista de Pokemones
<img width="1080" height="2272" alt="Screenshot_20250926-013924" src="https://github.com/user-attachments/assets/94473401-82b7-4031-a24c-bdeb981d6595" />

### Pantallas de detalles
<img width="1079" height="1417" alt="Screenshot_20250926-013721" src="https://github.com/user-attachments/assets/9b33ac3f-c8e4-40dd-ac9a-be8cca8712de" />

<img width="1079" height="1387" alt="Screenshot_20250926-013750" src="https://github.com/user-attachments/assets/3aec1834-5423-4fcc-be1a-76ce6ed62e64" />

