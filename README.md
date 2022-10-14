# anime-girls-with-programming-books-api
Fetch images of anime girls holding programming books

## Routes: 
* Root: `/`
  - List available languages
  - Sample response :
  `
  [{"name" : "SQL",
  "path" : "SQL"
      }, {
  "name" : "Scala",
  "path" : "Scala"
      }, {
  "name" : "Shell",
  "path" : "Shell"
      }, {
  "name" : "Smalltalk",
  "path" : "Smalltalk"
      }, {
  "name" : "Solidity",
  "path" : "Solidity" }]
  `

* Image based on language: `/language`
  - List all images related to the given programming language
  - sample : `/java` will generate a response similar to:
```
[ 
{ "name" : "Aharen_Reina_Java.png",
  "image" : "https://raw.githubusercontent.com/cat-milk/Anime-Girls-Holding-Programming-Books/master/Java/Aharen_Reina_Java.png"
}, {
  "name" : "Code_Geass_CC_How_To_Program_In_Java.png",
  "image" : "https://raw.githubusercontent.com/cat-milk/Anime-Girls-Holding-Programming-Books/master/Java/Code_Geass_CC_How_To_Program_In_Java.png"
}, {
  "name" : "FGO_Artoria_Pendragon_Java_For_Dummies_7.png",
  "image" : "https://raw.githubusercontent.com/cat-milk/Anime-Girls-Holding-Programming-Books/master/Java/FGO_Artoria_Pendragon_Java_For_Dummies_7.png" 
  }
]
  ```

* Random image for a language: `/language/random`
  - Returns a random image related to the given programming language
  - sample: `/python/random` will generate a response similar to:
```
{
  "name" : "Rias_Gremory_reading_automate_the_boring_stuff_with_python.png",
  "image" : "https://raw.githubusercontent.com/cat-milk/Anime-Girls-Holding-Programming-Books/master/Python/Rias_Gremory_reading_automate_the_boring_stuff_with_python.png"
}
```
