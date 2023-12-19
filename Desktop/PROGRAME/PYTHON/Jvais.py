import speech_recognition as sr
import pyttsx3
import pygame

def speak(text):
    engine = pyttsx3.init()
    engine.say(text)
    engine.runAndWait()

if __name__ == "__main__":
    text_to_speak = "Hello, I am Jarvis. How can I assist you?"
    speak(text_to_speak)

def speak(text):
    engine = pyttsx3.init()
    engine.say(text)
    engine.runAndWait()

def listen():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        recognizer.adjust_for_ambient_noise(source)
        audio = recognizer.listen(source)
    try:
        print("Recognizing...")
        command = recognizer.recognize_google(audio)
        print(f"User said: {command}")
        return command
    except sr.UnknownValueError:
        print("Could not understand audio")
        return ""
    except sr.RequestError as e:
        print(f"Could not request results; {e}")
        return ""

if __name__ == "__main__":
    speak("Hello, I am Jarvis. How can I assist you?")
    speak("can yo please open canva ")
    while True:
        command = listen().lower()
        if "stop" in command:
            speak("Goodbye!")
            break
        elif "hello" in command:
            speak("Hello! How can I help you?")
        else:
            speak("Sorry, I didn't understand that command.")
