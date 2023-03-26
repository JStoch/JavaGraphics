# JavaGraphics
## Simple graphics programme in Java made as an university assignment.

### Synopsis
This programme allows the user to display a picture made from shapes. There is no user interface at the moment, but the user can modify the picture in the main.java file.

### Available shapes
Below is the list of classes representing different shapes:
- Segment
- Circle
- Triangle
- Rectangle
- Star (star polygon) NOTE: to make a Star you need to specify the number of its points/arms and the density at which they connect. These numbers have to be relatively prime. Otherwise, the star won't be displayed.

One important to mention class is Point. It cannot be displayed, but it is used in all shapes to provide information about location, for example about the corners of a triangle. The overall position of a shape is determined as the upper left corner of a box surrounding it. 

### Additional features
Decorator project pattern was used for the making of SelectiveScene wrapper class. It provides additional functions for selecting shapes, which are then displayed with a border around them.

There is also an additional ComplexItem class, which isn't a shape in itself. Instead, it's a container for grouping items. Grouped items are displayed similarly to their single counterparts, but if a ComplexItem instance is selected, one border will appear around all its items. Additionaly, translating (or moving) a ComplexItem instance will result in moving all its items. 

### Example
Image below shows an imagine generated by the current code in Main class. It consists of:
- a polygon star with 70 radius, 7 points and density 5, positioned at (80, 80),
- a rectangle with 40 width and 60 height, positioned at (100, 15), filled,
- a circle with 20 radius, positioned at (130, 130), filled,
- a triangle with corners at (50, 40), (80, 45) and (50, 60), filled,
- a segment from (30, 80) to (50, 140),
- a group of items consisting of:
  - a star with 50 radius, 15 points and density 4, positioned at (230, 150),
  - a triangle with corners at (300, 300), (350, 400) and (320, 400).
  
All items are selected.

![image](https://user-images.githubusercontent.com/95025604/227782652-a1e16bb1-b2fe-44fb-ab1a-fe9cdc9ee08c.png)
