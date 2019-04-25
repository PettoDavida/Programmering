using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Threading;

namespace HangMan
{
    class CustomWords
    {
        public List<string> words;
    }

    class Program
    {
        static string[] art = {
@"





        ",
@"





=========",
@"      +
      |
      |
      |
      |
      |
=========",
@"  +---+
      |
      |
      |
      |
      |
=========",
@"  +---+
  |   |
      |
      |
      |
      |
=========",
@"  +---+
  |   |
  O   |
      |
      |
      |
=========",
@"  +---+
  |   |
  O   |
  |   |
      |
      |
=========",
@"  +---+
  |   |
  O   |
 /|   |
      |
      |
=========",
@"  +---+
  |   |
  O   |
 /|\  |
      |
      |
=========",
@"  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========",
@"  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
========="

};
        // ^Detta är min egna tabell för hangman målningen

        static List<string> Words = new List<string> { "jesus", "owl", "peasant", "cupboard", "pizza", "buttplug", "farmer", };
        // ^Detta är en redan gjord lista av ord ifall om att man inte har "word.json" filen så man fortfarande kan spela spelet men man kan inte ta bort eller lägga till ord i denna lista

        static Random number = new Random();
        // ^En random variabel som jag använder för att kunna randomisera vilket ord man får när man kör själv

        static int wordindex;
        // ^Denna int används för att välja vilket ord som ska användas när man spelar själv

        static string PlayorAdd;
        // ^Detta är variabeln som används i början när man får välja om man vill spela eller ta bort/lägga till ord.

        static string answer;
        // ^Ditt svar när man ska gissa på ordet Detta är en string så att man ska kunna gissa hela ordet

        static string YoN;
        // ^Denna används för frågor där det enda svaret är yes or no

        static char[] word;
        // ^Ordet man ska hitta

        static List<char> correctGuess = new List<char>();
        // ^Detta är en list som används för att hålla koll på vilka bokstäver som gissats och varit rätt

        static List<char> wrongGuess = new List<char>();
        // ^Detta är en list som används för att hålla koll på vilka bokstäver som gissats och varit fel men även hur många så att programmet skriver ut art Stringen

        static bool running; //Används medans spelet är igång 
        static bool won = false; //Denna blir true varje gång man vinner och då kan man välja om man vill spela igen eller inte och detta ändrar den till false om man vill köra igen annars så är den fortfarande true
        static bool Play = false; // När man har lagt till eller tagit bort ett ord så får man välja om man vill spela eller bara sluta spelet och då blir denna true om man vill spela igen så att den går tillbaka till början och ger en val hur man vill spela
        static bool Exists; // Används som en check för att kolla om man kan ta bort eller lägga till ord annars så skickar den tillbaka de som försöker
        // ^4 boolean som jag använder för olika saker när jag vill få programmet att göra saker beroende på vad som hänt innan


        static void Main(string[] args)
        {

            // Startar metoden
            CheckFile();

            // Skriver i konsolen 
            Console.WriteLine("Do you want to play or add custom words?");
            Console.WriteLine("You can also choose your own word if you want to play with a friend!");
            Console.WriteLine("It is recommended to add words if it is your first time!");
            Thread.Sleep(2000); // Den pausar programmet i 2 sekunder innan den clearar konsolen
            Console.Clear();

Start: // En label som programmet kommer hoppa till med en goto

            // Skriver i konsolen 
            Console.WriteLine("If you want to add words write (add)");
            Console.WriteLine("If you want to delete words write (delete)");
            Console.WriteLine("If you want to play write (play)");
            Console.WriteLine("If you want to choose your own word write(own)");
            Console.WriteLine("If you want to choose stop write (stop)");

            // tar in en string och sätter PlayorAdd value till den strängen
            PlayorAdd = Console.ReadLine();
            Console.Clear();
            if (PlayorAdd.ToLower() == "play") // om PlayorAdd = play: starta metoden Game
            {
                Game();
            }
            else if (PlayorAdd.ToLower() == "add")// om PlayorAdd = add: starta metoden Add
            {
                
                    Add();
                    if (Play) // om man har valt att spela igen i Add metoden så blir Play true och man går til labeln Start
                    {
                        goto Start;

                    }
                                
            }
            else if (PlayorAdd.ToLower() == "delete")// om PlayorAdd = delete: starta metoden Delete
            {
                CheckFileV2();
                if (Exists)
                {
                    Delete();
                    if (Play) // om man har valt att spela igen i Delete metoden så blir Play true och man går til labeln Start
                    {
                        goto Start;
                    }
                }else
                {
                    Console.WriteLine("There seems to be a problem. The list you are trying to edit doesn't contain anything or exist");
                    goto Start;
                }
                
            }
            else if (PlayorAdd.ToLower() == "own")// om PlayorAdd = own: starta metoden OwnGame
            {
                OwnGame();   
            }
            else if (PlayorAdd.ToLower() == "stop")// om PlayorAdd = stop: stoppa programmet
            {

            }
            else // om PlayorAdd = !play !own !delete !add !stop så ska den bara fråga igen genom att gå till labeln start igen
            {
                Console.WriteLine("Please try again!");
                goto Start;
            }
LostGame:
            if (wrongGuess.Count == art.Length - 1) // I metoden Game och OwnGame så stoppar den metoden när man har gissat för många gånger och då start den Lost metoden
            {
                Lost();
                if (Play)// I Lost så frågar den om man vill spela igen och om man villa så går den till start igen där man kan välja om man vill spela eller ta bort/lägga till ord
                {
                    goto Start;
                }      
            }
WonGame:
            if (won) // efter man har vunnit i Game eller OwnGame så blir won true och man startar PlayAgain metoden där den frågar om man vill spela igen och om man vill så fortsätter won att vara true och man går tillbaka till start
            {
                PlayAgain();
            }
            
            if (Play)
            {
                Game();
                if (won)
                {
                    goto WonGame;
                }
                else { goto LostGame; }

            }

            Console.WriteLine("Program Stopping..."); // visar att programmet stoppar och väntar i 1,5 sek så man ska hinna se
            Thread.Sleep(1500);
        }
        public static void HangManArt(int j)
        {
            if (j < art.Length)
            {
                Console.WriteLine(art[j]);
            }

        }
        public static void Game()
        {
            /// <summary>
            /// wordindex = skapar ett tal som är mellan 0 och så många ord som finns i arrayen med orden man ska gissa.
            /// </summary>
            wordindex = number.Next(0, Words.Count);
            
            answer = Words[wordindex];

            word = answer.ToCharArray();

            running = true;

            Console.WriteLine(answer);

            char[] correctAnswer = new char[answer.Length];
            for (int i = 0; i < correctAnswer.Length; i++)
            {
                correctAnswer[i] = '_';
            }

            while (running)
            {
Nothing:
                if (wrongGuess.Count == art.Length - 1)
                {
                    return;
                }

                Console.WriteLine("Guesses");
                foreach (char c in wrongGuess)
                {
                    Console.Write(c + " ");
                }
                Console.WriteLine(" ");
                Console.WriteLine();
                for (int i = 0; i < correctAnswer.Length; i++)
                {
                    Console.Write(correctAnswer[i] + " ");
                }
                Console.WriteLine();

                string guess = "";
                try
                {
                    guess = Console.ReadLine();
                    Console.Clear();

                }
                catch{ }

                if (guess == " ")
                {
                    Console.WriteLine("Try again!");
                    goto Nothing;
                }


                if (guess == answer)
                {
                    Console.WriteLine("You got it right!");
                    running = false;
                    won = true;
                }

                bool added = false;
                for (int i = 0; i < word.Length; i++)
                {
                    if (word[i] == guess[0])
                    {
                        correctAnswer[i] = word[i];
                        if (!correctGuess.Contains(guess[0]))
                        {
                            correctGuess.Add(word[i]);
                            added = true;
                        }
                    }

                }

                if (!added)
                {
                    if (!wrongGuess.Contains(guess[0]))
                        wrongGuess.Add(guess[0]);

                }

                string word2 = new string(correctAnswer);

                if (answer == word2)
                {
                    Console.WriteLine("You got it right!");
                    running = false;
                    won = true;
                }

                HangManArt(wrongGuess.Count);



            }
        }
        public static void OwnGame()
        {
            Console.WriteLine("Write what word you want your friend/friends to guess.");
            answer = Console.ReadLine();

            word = answer.ToCharArray();

            running = true;

            Console.WriteLine(answer);

            char[] correctAnswer = new char[answer.Length];
            for (int i = 0; i < correctAnswer.Length; i++)
            {
                correctAnswer[i] = '_';
            }

            while (running)
            {
Nothing:
                if (wrongGuess.Count == art.Length - 1)
                {
                    return;
                }

                Console.WriteLine("Guesses");
                foreach (char c in wrongGuess)
                {
                    Console.Write(c + " ");
                }
                Console.WriteLine(" ");
                Console.WriteLine();
                for (int i = 0; i < correctAnswer.Length; i++)
                {
                    Console.Write(correctAnswer[i] + " ");
                }
                Console.WriteLine();
                string guess = " ";
                try
                {
                    guess = Console.ReadLine();
                    Console.Clear();

                }
                catch
                {
                }

                if (guess == " ")
                {
                    Console.WriteLine("Try again!");
                    goto Nothing;
                }

                if (guess == answer)
                {
                    Console.WriteLine("You got it right!");
                    running = false;
                    won = true;
                }

                bool added = false;
                for (int i = 0; i < word.Length; i++)
                {
                    if (word[i] == guess[0])
                    {
                        correctAnswer[i] = word[i];
                        if (!correctGuess.Contains(guess[0]))
                        {
                            correctGuess.Add(word[i]);
                            added = true;
                        }
                    }

                }

                if (!added)
                {
                    if (!wrongGuess.Contains(guess[0]))
                        wrongGuess.Add(guess[0]);

                }

                string word2 = new string(correctAnswer);

                if (answer == word2)
                {
                    Console.WriteLine("You got it right!");
                    running = false;
                    won = true;
                }


                HangManArt(wrongGuess.Count);
            }

        }
        public static void Delete()
        {
        DelAgain:
            NoDelete();
            if (!Exists)
            {
                Console.WriteLine("You can't delete your only word please add more before you delete");
                return;
            }
            Console.WriteLine("Write what word you want to delete:");
            string existing = File.ReadAllText("words.json");
            Console.WriteLine(existing);
            string newWord = Console.ReadLine();
            Console.Clear();
            Words.Remove(newWord.ToLower());
            CustomWords newWords = new CustomWords();
            newWords.words = Words;
            String insertedword = JsonConvert.SerializeObject(newWords);
            File.WriteAllText("words.json", insertedword);
            Console.WriteLine("Do you want to delete another word?");
        FaultyAnswer:
            Console.WriteLine("yes or no");
            YoN = Console.ReadLine();
            Console.Clear();
            if (YoN.ToLower() == "yes")
            {
                goto DelAgain;
            }
            else if (YoN.ToLower() == "no")
            {
                Console.WriteLine("Do you want to play?");
            incorrectAnswer:
                Console.WriteLine("Yes or no");
                YoN = Console.ReadLine();
                if (YoN.ToLower() == "yes")
                {
                    Play = true;
                }
                else if (YoN.ToLower() == "no")
                {
                    Play = false;
                    Console.Clear();
                }
                else
                {
                    goto incorrectAnswer;
                }
            }
            else
            {
                Console.WriteLine("Try Again!");
                goto FaultyAnswer;
            }
        }
        public static void Add()
        {
        AddAgain:
            CustomWords oldWords = null;
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                oldWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
            }

            Console.WriteLine("Write what word you want to add:");
            string existing = File.ReadAllText("words.json");
            Console.WriteLine(existing);
            string newWord = Console.ReadLine();
            Console.Clear();
            Words.Add(newWord.ToLower());
            oldWords.words.Add(newWord);
            String insertedword = JsonConvert.SerializeObject(oldWords);
            File.WriteAllText("words.json", insertedword);
            Console.WriteLine("Do you want to add another word?");
        FaultyAnswer:
            Console.WriteLine("yes or no");
            YoN = Console.ReadLine();
            Console.Clear();
            if (YoN.ToLower() == "yes")
            {
                goto AddAgain;
            }
            else if (YoN.ToLower() == "no")
            {
                Console.WriteLine("Do you want to play?");
incorrectAnswer:
                Console.WriteLine("Yes or no");
                YoN = Console.ReadLine();
                if (YoN.ToLower() == "yes")
                {
                    Play = true;
                }
                else if (YoN.ToLower() == "no")
                {
                    Play = false;
                    Console.Clear();
                }
                else
                {
                    goto incorrectAnswer;
                }
            }
            else
            {
                Console.WriteLine("Try Again!");
                goto FaultyAnswer;
            }
        }
        public static void PlayAgain()
        {
            Console.WriteLine("Want to play again? Answer: yes or no");
        FaultyAnswer:
            YoN = Console.ReadLine();
            Console.Clear();

            if (YoN.ToLower() == "yes")
            {

                correctGuess = new List<char>();
                wrongGuess = new List<char>();
                Play = true;
            }
            else if (YoN.ToLower() == "no")
            {
                running = false;
                won = false;
                Play = false;
            }
            else
            {
                Console.WriteLine("Please try again!");
                Thread.Sleep(1000);
                Console.Clear();
                Console.WriteLine("Play again? yes or no");
                goto FaultyAnswer;
            }
        }
        public static void Lost()
        {
            Console.WriteLine("You Lost!");
            Console.WriteLine("The answer was: " + answer);
            Console.WriteLine();
            Console.WriteLine("Want to play again? Answer: yes or no");
FaultyAnswer:
            YoN = Console.ReadLine();
            Console.Clear();

            if (YoN.ToLower() == "yes")
            {
                correctGuess = new List<char>();
                wrongGuess = new List<char>();
                Play = true;
            }
            else if (YoN.ToLower() == "no")
            {
                Play = false;

            }
            else
            {
                Console.WriteLine("Please try again!");
                Thread.Sleep(1000);
                Console.Clear();
                Console.WriteLine("Play again? yes or no");
                goto FaultyAnswer;
            }
        }
        public static void CheckFile()
        {
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                CustomWords newWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
                if (newWords.words.Count > 0)
                {
                    Words = newWords.words;
                }
                
            }
        }
        public static void CheckFileV2()
        {
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                CustomWords newWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
                if (newWords.words.Count > 0)
                {
                    Exists = true;
                }

            }
        }
        public static void NoDelete()
        {
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                CustomWords newWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
                if (newWords.words.Count <= 1)
                {
                    Exists = false; 
                }

            }
        }
    }
}
