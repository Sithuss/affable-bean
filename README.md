## affable-bean

### _Do the instructions step-by-step_

in mysql database drop datebase [your db] and createdatabase [yourdb].

In the project application properties, set spring.jpa.hibernate.ddl-auto=create AND run the app.

Then, in mysql database use [yourdb] and add the following script:

> INSERT INTO `category` VALUES (1,'dairy'),(2,'meats'),(3,'bakery'),(4,'fruit & veg');

> INSERT INTO `product` VALUES (1,'semi skimmed (1L)','2023-01-30','milk',1.70,1),(2,'mild cheddar (330g)','2023-01-30 03:15:48','cheese',2.39,1),(3,'unsalted (250g)','2023-01-30 03:15:48','butter',1.09,1),(4,'medium-sized (6 eggs)','2023-01-30 03:15:48','free range eggs',1.76,1),(5,'rolled in fresh herbs<br>2 patties (250g)','2023-01-30 03:15:48','organic meat patties',2.29,2),(6,'matured, organic (70g)','2023-01-30 03:15:48','parma ham',3.49,2),(7,'free range (250g)','2023-01-30 03:15:48','chicken leg',2.59,2),(8,'reduced fat, pork<br>3 sausages (350g)','2023-01-30 03:15:49','sausages',3.55,2),(9,'600g','2023-01-30 03:15:49','sunflower seed loaf',1.89,3),(10,'4 bagels','2023-01-30 03:15:49','sesame seed bagel',1.19,3),(11,'4 buns','2023-01-30 03:15:49','pumpkin seed bun',1.15,3),(12,'contain peanuts<br>(3 cookies)','2023-01-30 03:15:49','chocolate cookies',2.39,3),(13,'2 pieces','2023-01-30 03:15:49','corn on the cob',1.59,4),(14,'150g','2023-01-30 03:15:49','red currants',2.49,4),(15,'500g','2023-01-30 03:15:49','broccoli',1.29,4),(16,'250g','2023-01-30 03:15:50','seedless watermelon',1.49,4);

And then in the project application properties, set spring.jpa.hibernate.ddl-auto=update.

Finally, RE-run the application.

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)
