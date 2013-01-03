Design Patterns that are used:

1- state/template pattern.
2- observer pattern.
3- command (master/slave) pattern.
4- singleton pattern.
5- MVC pattern.
6- account pattern


/////////////////////////////

1-state pattern: its used with the relation between customer and account class, where the customer may choose
different account types, such as the case for silver,gold, bronze for Creditcard applications, where as once 
the Account is created a parameter passes the type of the account to its super class account.
if we use the created accounts for more than that, such as adding interest to account balances, so we would
methods on both the context(account) have operations while its extension classes also has operations.
the pattern changes to template pattern. 
the difference between the state and template pattern is that state a behavioral implicit approach, while 
template is an explicit behavioral approach.

2-observer pattern: this pattern is the core of the application cause it provides a door , a hotspot, 
a plugin to the framework, here the observer is the accountmanager and the subjects are in the busclass 
while more subjects can be added by extending the busclass, as i did with BankFrm.
i will talk more about this in the DI and IOC section.

3-command pattern:this is as important as the observer pattern, this is the behavior aspect of the 
framework, so here is where motion happens and components act with eachother. 
basically what i did is that i tweeked the command pattern a little by providing two methods
execute and executeAll-executeLogic, here each command have these two methods, same idea as 
master/slave in hardware design, actually we can call it a master/slave pattern, where we would
have a master command such as Cmd that executes all other commands depending on some logic
that we implemented, we can do that in two ways, i call them serial and parallel approuch,
serial resembles the case where the master and slaves are in the same level, extended 
from the same class, so what makes one of the commands the commander of others
happens up stairs in the accountmanager, we can call this also the Rank pattern, an extension of the
command pattern, so command + serial = rank pattern.
another way is the parallel approuch where as the master command is defined and all other commands
are extended and used below it, so the master command doesnt change, he is assigned from the gods, from 
a bove and he is king, so we can say command + parallel = king pattern.

4-singleton pattern: its useful to facilitate the interaction between objects, essencial objects that 
we only need one copy of them so they can be passed around, here in our application, its Finco 
and accManager, so its a nice way to handle control and storage cause we need only one control 
and one storage in our case, we dont even extend them, we use them as they are in the framework.
which is key for enabling the framework to actualy be a framework :)

5-MVC pattern: MVC is an old subject so nothing creative about it , but i have to mention it here, 
the controller is the accManager where  as the view is the main GUI basicaly, the model is Finco,
the classes that need to be created to be saved in FInco, operated on itself, and its relative
classes

6-account pattern: this is a nice way to keep track of yourself, so along the way you keep track of yourself
so you wont get lost, and in some cases if you do , you can track back, another word roll back and find 
your way again , so this is a pattern to track an attribute and keep a history list of all its changes. 
many things can be done here with this pattern, so i call this pattern the tracker pattern. 
  
 
Hotspots of the framework: (DI and IOC).

I kept DI and IOC on the title cause they are very important for the concept for hotspots or plugins, 
nothing would work without them. 
so how do we accomplish that? Inversion Of Control means that we pass control to someone else. 
so for example the application and it's platform have IOC, here in our framework its much simpler 
the Door for the framework is an ActionListener object inside the accManager, so either if you use
the default GUI in the framework , or use our own, we still can either way use the framework 
by calling on the accManager and getting the ActionListener object, attach it to our subjects
and thats it we are hooked! here is Inversion Of Control, that is the door, the fact that accManager
is singleton makes it even easier, so we wont have to worry about passing the controller around
cause we only have one object of it. 

but the story does not end here, cause without DI the framework is crippled , we opened a gate 
in the framework , and now the framework is hungrey for objects, so best food is something 
that she knows of and has a reference to it, so we feed it the master command.

here our job is done the framework takes over, we opened the gate and we fueled it with a
master command.

thats the story of this project from my side, i enjoyed it, it was beautiful. 
