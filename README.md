# Tridroid Developers Password Protected Diary 1022 Project
# Phase 0:
__Team Name:__ The Tridroid Developers  

__Team Members’ Information (3 Members in Total):__

- __Name:__ Aijaisarma Sabaratnasarma  

  - __York U Email (Eclass Email):__ Aijaysarma14@gmail.com  
 
  - __Lecture and Lab Section:__ Section M, Lab 01   

- __Name:__ Andre G. Muyalde 

  - __York U Email (Eclass Email):__ andmuy21@my.yorku.ca   

  - __Lecture and Lab Section:__ Section O, Lab 01   

- __Name:__ Ethan Rei C. Afable   

  - __York U Email (Eclass Email):__ ethanrei@my.yorku.ca  

  - __Lecture and Lab Section:__ Section O, Lab 01   

__Project Title:__ Password Protected Diary App 

__Project Description:__

Our app will load up with a screen welcoming the user and directing them to press a button and enter a password to access their notes. If the password is entered correctly, they will be able see a list of notes with the name of the note as a label, then clicking on it will reveal the note itself. There will also be 2 buttons to add new notes and delete notes that are not needed. If the user leaves the screen that shows all the notes, then to go back to that page they will have to re-enter the password. If we have time, we might add a feature to change your password or to edit currently saved notes.   

# Phase 1

__Team Name:__ The Tridroid Developers  

__Team Members:__ Aijaisarma Sabaratnasarma, Andre G. Muyalde, Ethan Rei C. Afable 

__Project Title:__ Password Protected Diary App 

__Project Description:__

Our app will load up with a screen welcoming the user and directing them to press a button and enter a password to access their notes. If the password is entered correctly, they will be able see a list of notes with the name of the note as a label, then clicking on it will reveal the note itself. There will also be 2 buttons to add new notes and delete notes that are not needed. If the user leaves the screen that shows all the notes, then to go back to that page they will have to re-enter the password. If we have time, we might add a feature to change your password or to edit currently saved notes.

__Functional Requirements for Project:__

1. Users can set a password for their diary and change it at any time.  
   - The first time the app is used, it will ask the user to set a password. Any subsequent uses of the app, the user must put in their password to access the diary.  
   - If the user forgets their password, there will be a “change password option”.  
   - Passwords can contain any type of characters on a keyboard but must be within 15 characters.  
   - All password features will be operated using buttons and methods in Android Studio. 
2. In the main menu of the app, users will be able to scroll through their notes.  
   - Each note will have a numeric label with a title that the user sets. If a title is not specified, the default title given will be “Note [positive integer]”.
   - Each note label will be clickable to access the note on a separate page controlled by Android Studio.
3. Users can create new notes by pressing a button on the main menu of the app.
   - The create button will prompt the user to give a title for the new note, after which they click a confirm button.  
   - Adds a new note label to the main page, which then the user can click to edit their newly created note.  
   - Button will be located at the bottom right of the main menu screen 
4. Users can delete existing notes by pressing a button then selecting the notes to delete and pressing the same button.  
   - When notes are deleted, the main menu should enumerate itself to make sure the numbers of each note label are in order.   
   - Button will be located at the bottom of the main menu screen, centered.  
5. Each note page will have a button to save their current changes made to the note. 
   - If a user tries to leave the note’s page without saving, the user will be prompted if they would like to save before exiting.  
6. Each page on the app will have a “back” button to make navigating the app easier by taking the user to the previous page.
   - If the user is on the main menu, then the back button goes to the launch screen (note to get back to the main menu the password must be re-entered).  
   - If the user is within one of their notes, then the back button takes them to the main menu where all their notes can be found. 
7. Ability to recover previous edits of notes. 
   - There will be a button on the page of each note the user creates that gives access to previous edits. (Through either another page or a slide down window) 
   - The app will store the past 5 “saves” of a note they had made. 
   - The user will be able to preview previous iterations of their notes on a separate page. 
     - Reverting will erase the saved edits that come after the chosen to save (user will be notified if this is ok with them) 
8. Users will have access to a toolbar to format their text in their notes in different ways.  
   - Ability to bold, italic, underline, etc. 
   - Collapsible; Users can reveal the toolbar through a user input, so it is not always on the screen.  
9. Users will be able to add text to their notes via the following “texting” based method.  
   - Users enter text through a textbox and push/send their additional text to their existing notes. 
   - Existing text within their notes may be removed by the user through a deletion button beside the notes. 
10. Search bar for searching notes by note title on the main menu. 
   - Search for the name of the note by its filename.  
   - The app will 
     - bring up the file with the corresponding filename. 
     - bring up the files with the closest filenames if there is no file with the filename (e.g. searched for ‘blue’; returns ‘blue1.txt’ ‘blue2.txt’).  

# Phase 2

[Here is a functional view of all the wireframes together with mobile interactions to access different wireframes (prototype)]( https://www.figma.com/proto/yYpxm9uzGJSHYwdTuoGRsT/Password-Protected-Diary-App?node-id=1%3A2&scaling=scale-down&page-id=0%3A1&starting-point-node-id=1%3A2  )

[Figma Layouts showing all Wireframes with Arrows]( https://www.figma.com/file/yYpxm9uzGJSHYwdTuoGRsT/Password-Protected-Diary-App?node-id=0%3A1  )

[GitHub Repository:]( https://github.com/duyamn/Tridroid-Developers-Password-Protected-Diary-1022-Project  )

Technologies and Designs of Classes:
 
Technologies: Android Studio IDE and Java Programming Language.
 
Classes:
•	MainActivity.java
•	MenuOfNotes.java
•	NoteEditer.java
 
Methods/Variables for each Class:
•	MainActivity.java
o	Instance variables:
	Private AlertDialog dialog
	Private AlertDialog.Builder dialogBuilder
o	Methods:
o	Protected void OnCreate(Bundle savedInstanceState) 
	Creates the Diary title screen to appear on the device. 
o	Public void createChangePasswordDialog(View v)
	Opens a prompt for the user to change their password using the dialog and dialogBuilder instance variables. 
	If an empty string is detected, then the message “Please Enter a Password” is directed to the user. 
	If a non-empty string is entered, then the string is written to a file called “Password.txt” and the message “Successful Password Change” is directed to the user. 
o	Public void createEnterPasswordDialog(View v)
	Opens a prompt to log in to the diary using the dialog and dialogBuilder instance variables.
	Reads the user set password from “Password.txt” and sets it to a string variable. 
	If the string variable is equal to what the user typed in, then the diary opens, and the user is directed to the MenuOfNotes screen with a message indicating “Welcome”
	If the string variable is not equal to what the user types in, then a message saying “Incorrect Password” is directed to the user.  


•	MenuOfNotes.java
o	Instance variables:
	Public static int count = -1
	Public static ArrayList<String> names_list = new ArrayList<>() (Contains a Strings of the form “Note [positive number]” where positive number can range from 1-25)
o	Methods:
	Protected void onCreate(Bundle savedInstanceState) 
	Creates an instance of the MenuOfNotes class
	Populates the MenuOfNotes listView with all 25 notes
	All notes are clickable and call the openNoteEditor method.
	Provides a search view that allows the user to quickly access any given note.
	If the provided note in the searchView query is a valid note name, openNoteEditor is called.
	Public void openTitleScreen(View v)
	Goes back to the opening screen of the app
	Public void openNoteEditor
	Opens selected note for editing in the app
 
•	NoteEditor.java
o	Instance Variables:
	Private boolean changed = false
o	Methods:
	Protected void onCreate(Bundle savedInstanceState) 
	Creates an instance of the NoteEditor class.
	Retrieves the note number of the current note being edited from the MenuOfNotes class (from the global count variable).
	Retrieves the text of the specified note from a .txt file of the same name and places it within the textView (of id noteText). 
	Public void openMenuOfScreen(View view) 
	Creates a menu of Notes object and brings the user back to the menu of notes layout.
	Urges the user to save if they haven’t done so.
	Public void saveText(View view)
	Rewrites whatever current text is inside the textView (of id noteText) onto the file named “Note #.txt” where # is the number of the note.


Changes from previous design (Phase 1 and 2 Changes): 
1.	There is instead a finite number of notes each named “Note #” where “#” ranges from 1-25 and a user is unable to add or delete more notes or the existing ones (Design point 3 and 4 from Phase 1). This was changed due to difficulties in finding how to save an infinite/unknown number of notes (text files) and to consistently update information in those text files. Instead, we now have 25 notes each with a pre-set name where the text inside each note can be changed (more text can be added or erased) at any time instead of creating and deleting new notes when a user wants to add new information or delete existing ones.    

2.	Omitted the option to retrieve past notes (Design point 7 from Phase 1). Like Change 1 this was also changed as it was difficult to determine how to save have multiple versions of a note in either 1 or multiple text file. As well as 2D string arrays were attempted to be used but the data inside them kept getting erased every time a user loaded up the app. Thus, this idea was scraped. 

3.	Changed the “texting” based style of updating notes in favour of editing a single scrollable textView (Design point 9 from Phase 1). This was only changed due to aesthetic reasons. Using the “texting” based style made the UI look very clustered and the listViews used for texting weren’t ideal for changing the text in notes if a user wanted to change the information in them. Hence, we made it more like a word document where you have one vertically scrollable textview that can have as much text as the user wants.  

4.	Removed the functionality of searching for the closest search result (As all notes are named “Note #”). The Search bar is functional, but only when the name of 1 of the 25 existing notes are entered. For example, if any string other than strings of the form “Note [1-25]” is entered then the search button does nothing but when a string of the form “Note [1-25]“ is entered then when the search button is clicked the app opens that note up. The main difference from here is that the search bar doesn’t filter out the names as the user types them mainly because all the names are almost the same except for the number. 

5.	Based on the above 4 changes to Phase 1, in Phase 2 here are the main differences. The Note deletion page and the Note history page are not implemented as those features, we scraped due to Change 1 and 2. The Menu of Notes page and Title Screen are practically the exact as the Phase 2 layout with just minor UI changes and shifting the positions of some buttons around. Likewise, the NoteEditor Screen has a different UI but its function and how it works is mostly the same. The connections between layouts are also preserved with the only difference being buttons designed to go to certain screens have been removed due to some features being changed, for example “plus sign” button removed as adding notes is not possible.        

     


![image](https://user-images.githubusercontent.com/88597896/161405847-43d12fe5-00d6-4d7d-922d-8295909cb0a1.png)


