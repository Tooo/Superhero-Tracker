# Superhero Tracker
Create superheroes and modify their civilian saved count. 
Superheroes will be saved when the program ends.
Once the program is loaded back, the previous superheroes will be loaded.

## Installation
1. Download, install and run [IntellJ Community Edition](https://www.jetbrains.com/idea/download/)
2. Click "Get from VCS" or File->New->Project From Version Control
3. Insert the following URL:
```
https://github.com/Toooo123/Superhero-Tracker.git
```
4. Run Main

## Tracker
The Superhero Tracker will do the following things:
- List all superheroes
- Add a new superhero
- Remove a superhero
- Update number of civilians saved by a superhero
- List Top 3 superheroes
- Debug Dump (toString)

### JSON
Superheroes will be saved in a JSON file named "superhero-list.json" once the program terminates.
Here's an sample JSON file.
```json
{"superhero":[
  {
    "name": "Cookie Monster",
    "superpower": "Eating Cookies",
    "height": 97.0,
    "civiliansSaved": 0
  }
]}
```

## Sample Run
With this run, the 3 Superheroes will be created and each superhero's civilians saved will be updated.
```
********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```2```
```
Enter Hero's name:
```
Input: ```Cookie Monster```
```
Enter Hero's height in cm:
```
Input: ```97```
```
Enter Hero's Superpower:
```
Input: ```Eating Cookies```
```
Cookie Monster has been added to the list of superheroes.
```
Add two more superheroes:
- Pikachu, 30cm, Volt Tackle
- Spiderman, 170cm, Spider Sense
```
Pikachu has been added to the list of superheroes.
Spiderman has been added to the list of superheroes.
```
```
********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```4```
```
1. Hero name: Cookie Monster, height: 97.0cm, superpower: Eating Cookies, saved 0 civilians.
2. Hero name: Pikachu, height: 30.0cm, superpower: Volt Tackle, saved 0 civilians.
3. Hero name: Spiderman, height: 170.0cm, superpower: Spider Sense, saved 0 civilians.

Enter Hero number to update civilian count or Enter 0 to cancel
Enter>>
```
Input: ```1```
```
Enter new civilian save count:
```
Input: ```200```
```
Number of civilians saved by Cookie Monster has been updated from 0 to 200
```
Update Pikachu and Spiderman civilian count:
- Pikachu: 10
- Spiderman: 1000
```
Number of civilians saved by Pikachu has been updated from 0 to 10
Number of civilians saved by Spiderman has been updated from 0 to 1000
```
```
********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```1```
```
1. Hero name: Cookie Monster, height: 97.0cm, superpower: Eating Cookies, saved 200 civilians.
2. Hero name: Pikachu, height: 30.0cm, superpower: Volt Tackle, saved 10 civilians.
3. Hero name: Spiderman, height: 170.0cm, superpower: Spider Sense, saved 1000 civilians.

********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```5```
```
1. Spiderman has saved 1000 civilians
2. Cookie Monster has saved 200 civilians
3. Pikachu has saved 10 civilians

********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```6```
```
1. Superhero{name='Cookie Monster', height=97.0, civiliansSaved=200, superpower='Eating Cookies'}
2. Superhero{name='Pikachu', height=30.0, civiliansSaved=10, superpower='Volt Tackle'}
3. Superhero{name='Spiderman', height=170.0, civiliansSaved=1000, superpower='Spider Sense'}

********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```3```
```
1. Hero name: Cookie Monster, height: 97.0cm, superpower: Eating Cookies, saved 200 civilians.
2. Hero name: Pikachu, height: 30.0cm, superpower: Volt Tackle, saved 10 civilians.
3. Hero name: Spiderman, height: 170.0cm, superpower: Spider Sense, saved 1000 civilians.

Enter Hero number to be removed or Enter 0 to cancel
Enter>>
```
Input: ```3```
```

Spiderman has been removed from the list of superheroes.

********************
 Super Hero Tracker 
********************
1: List all superheros
2: Add a new superhero
3: Remove a superhero
4: Update number of civilians saved by a superhero
5: List Top 3 superheroes
6: Debug Dump (toString)
7: Exit
Enter >> 
```
Input: ```7```

### JSON File
```
{"superhero":[
  {
    "name": "Cookie Monster",
    "superpower": "Eating Cookies",
    "height": 97.0,
    "civiliansSaved": 200
  },
  {
    "name": "Pikachu",
    "superpower": "Volt Tackle",
    "height": 30.0,
    "civiliansSaved": 10
  }
]}
```

