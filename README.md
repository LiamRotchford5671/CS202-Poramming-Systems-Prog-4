# CS202-Poramming-Systems-Prog-4
Program 4 under Karla Fant at Portland State University

Description:

This program is esstianlly a text based adventure game, at each move we are given the choice to move to the left or right and then are given a event space, (a decision, chance, spell, or end game). This program is building only the "map" and a test player to move through the map. The player is given stats that are effected by the events on the map spaces.

This Program was built using intelliJ IDE

Data Structure: Binary Search Tree

      Heirarchy 1:    (journey is abstact base class)
      
      Journey            Journey         Journey            Journey
          |                  |               |                  |
          |                  |               |                  |
       chance             decision         end game           spell

      Heirarcy 2:
      
      Manager ------ bnode
