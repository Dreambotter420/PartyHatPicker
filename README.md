# PartyHatPicker
Script for accumulating Grain, Cabbage, Potatos, and Onions while wearing a Partyhat in Old School Runescape. Written in Java for the Dreambot client from the barebones tree framework found here: https://github.com/LostVirt/Dreambot-Tree-Branch-Framework


Due to a lack of features in a single picking script on the Dreambot SDN, I made my own, with the following features:

-Picking algorithm designed to emulate a human being forced to pick an inventory full of stuff if they ever had to

-Assigns random delay modifier on startup which affects all internal delays so that many accounts can pick at different rates

-Chooses an area of the best available areas to Pick from in F2P then randomizes this after a random amount of bank deposits then randomizes bank deposit threshold

-Hops to another random world after a random amount of Picks then randomizes world hop pick threshold

-While picking, hops to a random world immediately after detecting either a player nearby or another Picker you're competing with

-Sells stuff at GE after accumulating a random amount of stuff

-Enables run if walking and energy level is above a random threshold then randomizes run threshold

-Moves camera up and zooms out after awhile to combat dreambot's camera movement embedded in the API calls

However, all of these features are futile and will absolutely get your fresh F2P account banned after doing the above for several hours. To combat this, I have hacked the mainframe, ran the data through IBM Watson and Google DeepMind, and observed the ultimate solution. Your character will strip naked then buy and equip a random-colored partyhat for the entire duration of picking if they have enough money (8k).


Missing features:

-PK Mule after a random total GP threshold using sockets
