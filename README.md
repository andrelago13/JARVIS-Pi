# JARVIS-Pi

 If you are reading, it means I invited you to see my project, the JARVIS Pi.
 This account was specifically created to allow the people I choose to see the code and description of this project. I have chosen this approach because I feel that I must show this project to possible job recruiters or teachers, and therefore I ask you not to modify any of the code in this repository, and also not to share this information with anyone since it is a private project.

 So what is the JARVIS Pi?

 My goal is to create a virtual personal assistant which will be placed somewhere inside a house or office (in one or more rooms). The singularity of this system is that it will not require a keyboard, mouse or screen, since you will be able to interact with it using only your voice.
 Some of the features I would like to include would be:

* Scheduling alarms and timers
* Using a chronometer (start, stop and lap)
* Weather forecast
* Playing music
* Opening or closing electrical blinds on windows
* Toggling lights

I'm programming the software using Java on Eclipse for several reasons: I feel comfortable coding in Java quickly and correctly; the use of Design Patterns is made more simple by Java itself and the Eclipse features; Java simplifies interaction with microphones and speakers.
I have also considered using C++, mainly because it is more efficient than Java in many aspects, but since I don't expect the final result to be a very "heavy" program, I think Java will do just fine.

Also, I intend to run the software on a Raspberry Pi, since it is a small and powerfull device with many features, such as internet acces, which is perfect if I go on to building a mobile app to interact with the JARVIS system via WiFi.

Please remember to keep this information private, and thank you for your cooperation. This is a very important project for me, so you must be somehow important to me since I gave you access to my biggest hobbie of all! Thank you!

##Current status
Functionality already implemented:
* Voice recognition and text synthesizer libraries integrated with custom classes, allowing easy voice recognition results analysis and user response with synthesizer
* State Machine to make it possible to easily add new functionality
* Telling the current weather condition and the following day's forecast
* TextSystem to easily add new text messages (both from and to the user)

Libraries in use:
* [Sphynx](https://github.com/cmusphinx/sphinx4) - voice recongnition
* [FreeTTS](http://freetts.sourceforge.net/docs/index.php) - text synthesizer
* [Weather Underground](http://portuguese.wunderground.com/weather/api/) - current weather condition and forecast
