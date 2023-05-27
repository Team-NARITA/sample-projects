# Sample-projects 
react.js + SpringBootのサンプルプロジェクトです

## 環境構築方法
dockerを使用し環境を構築します  
`docker-compose up -d`

## react.js(front-end)
`docker-compose exec front-end bash`: コンテナ(front-end)に入る  
`cd app`: appディレクトリに移動  
`npm run start`: 開発用サーバーの起動

## SpringBoot(back-end)
`docker-compose exec back-end bash`: コンテナ(back-end)に入る  
`./gradlew bootRun`: サーバーの起動