# Personal Project: Fit-Foodie

## Diet Tracker Application

- This program is like a **food ledger**. It provides a platform for users to **record their everyday eating habits**, and they can use the built-in options to record the food they eat every day and its calories.
  This application **evaluates the user's nutritional intake for the day** based on the food intake entered by the user as well as the height and weight entered by the user. 



- Anyone who wants to keep track of their eating habits, such as the need to control their dietary intake for fitness, can use this app.



- People today are becoming more and more conscious of their appearance, and many may even go on excessive diets in pursuit of a single aesthetic leading to an increase in body burden. This application evaluates the user's nutritional intake and can **helps the user to build a more healthy diet based on their body condition**, instead of pursuing an extreme diet that doesn't fit their own condition. 

## User Stories:

- As a user, I want to be able to create a new foodie diary.
- As a user, I want to be able to add a food item to my foodie diary.
- As a user, I want to be able to view a list of food items in my foodie diary based on the food type.
- As a user, I want to be able to delete a food item from my foodie diary.
- As a user, I want to be able to input my height, weight, gender and age and check whether my intake today meets the healthy requirement. 
- As a user, I want to be able to save my food diary to file (if I choose).
- As a user, I want to be able to be able to load my food diary from file (if I choose to do so).


## Instructions for Grader
- You can locate my visual component at the first panel showed up in this app, where I added a logo for my foodie diary
draw by myself. You can also find another visual components at the menu panel where again shows the logo. Also, there are 
different pictures displayed every time you click "add to my diary" and "delete this food item" as well.
I also used border
at the input info panel where I surround each text field with titled boarder. 
- You can choose whether to load from the history foodie diary at the beginning of this application. If you choose "yes", it will load from the history data. 
If you choose "no", you can input your personal information to generate a newly customized foodie diary.
- You can generate the first required action related to adding Xs to a Y by clicking the "record food items" button, then
you will be direct to a new panel. In this panel, you can select a food type from the drop dow box, and input
the name of the food item you want to add. Then click "add to my diary" 
button, once you see a "Food item added !" message on the right-hand side, 
that means your food item has been added to the diary. 
- You can generate the second required action related to adding Xs to a Y by clicking "remove this food item" button, 
  on the panel you were directed to in the last step. In this panel, you can select a food type from the drop dow box, and input
  the name of the food item you want to add. Then click "delete this food item"
  button, once you see a "Food item deleted !" message on the right-hand side,
  that means your food item has been added to the diary.
- You can generate the third required action related to adding Xs to a Y by clicking "view current foodie diary" 
on the panel you were directed to in the last step. You can see what's in your foodie diary 
on the right-hand side of the panel. 
- You can save the state of my application by clicking "save current foodie diary" button on the main menu panel. However, if you choose not to load from history
data at the beginning, the information you input will be saved automatically; but you can decided whether to save your food items by choosing to click the save button. 

## Phase 4: Task 2
Sat Apr 01 21:15:56 PDT 2023
created new food diary with given info: userName = null, weight = 0kg, height = cm, age = 0, gender (physical) = null

Sat Apr 01 21:16:10 PDT 2023
created new food diary with given info: userName = Zoey, weight = 50kg, height = cm, age = 18, gender (physical) = female

Sat Apr 01 21:16:14 PDT 2023
Added food item: banana

Sat Apr 01 21:16:22 PDT 2023
Added food item: chicken

Sat Apr 01 21:16:29 PDT 2023
Added food item: chocolate

Sat Apr 01 21:16:32 PDT 2023
deleted food item: chocolate

## Phase 4: Task 3 Reflection
- One refactoring I can improve on my project is that instead of have a big block of code in a single 
GUI class, I could separate it into different classes based on the panels. As what we learnt in class about the
  Single Responsibility Principle, each panel could have been a 
class, and since all of them used similar methods during the setup stage. I could make a panelSetup interface and
let all the panel classes implements that. 
- Another thing that I can improve with my project is that instead of using ArrayList to 
represent food diary, I could use a HashSet. Because I don't need to preserve the order in the 
food diary and a HashSet would be easier to find a food item in the food diary. 
