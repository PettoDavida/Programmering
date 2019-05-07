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
        #region Vars
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

        static List<string> Words = new List<string> { "jesus", "owl", "peasant", "cupboard", "pizza", "farmer", };
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
        #endregion

        static void Main(string[] args)
        {

            // Startar metoden
            CheckFile();

            // Skriver i konsolen 
            Console.WriteLine("Thank you for choosing to play my game");
            Console.WriteLine("Today you will try my Hangman");
            Thread.Sleep(2000); // Den pausar programmet i 2 sekunder innan den clearar konsolen
            Console.Clear();// Tar bort all text i konsolen

        Start: // En label som programmet kommer hoppa till med en goto

            // Skriver i konsolen 
            Console.WriteLine("    Write the number you want");
            Console.WriteLine("       1 - Play Alone");
            Console.WriteLine("       2 - Play with a friend");
            Console.WriteLine("       3 - Add Words");
            Console.WriteLine("       4 - Remove Words");
            Console.WriteLine("       5 - Exit");
            Console.OutputEncoding = System.Text.Encoding.ASCII;
            Console.WriteLine("");

            // tar in en string och sätter PlayorAdd value till den strängen
            PlayorAdd = Console.ReadLine();
            Console.Clear();// Tar bort allt i konsolen
            if (PlayorAdd.ToLower() == "1") // om PlayorAdd = 1: starta metoden Game
            {
                Game();
            }
            else if (PlayorAdd.ToLower() == "3")// om PlayorAdd = 3: starta metoden Add
            {
                
                    Add();
                    if (Play) // om man har valt att spela igen i Add metoden så blir Play true och man går til labeln Start
                    {
                        goto Start;

                    }
                                
            }
            else if (PlayorAdd.ToLower() == "4")// om PlayorAdd = 4: starta metoden Delete
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
            else if (PlayorAdd.ToLower() == "2")// om PlayorAdd = 2: starta metoden OwnGame
            {
                OwnGame();   
            }
            else if (PlayorAdd.ToLower() == "5")// om PlayorAdd = 5: stoppa programmet
            {
                goto Stop;
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
Stop:
            Console.WriteLine("Program Stopping..."); // visar att programmet stoppar och väntar i 1,5 sek så man ska hinna se
            Thread.Sleep(1500);
        }
        #region Methods
        public static void HangManArt(int j)
        {
            if (j < art.Length) // Kollar så att mängden av felgissningar inte är för många så att den ska printa ut hangman arten
            {
                Console.WriteLine(art[j]);
            }

        }
        public static void Game()
        {
            /// <summary>
            /// wordindex = skapar ett tal som är mellan 0 och så många ord som finns i arrayen med orden man ska gissa.
            /// answer = tar ut ett ord ur Words arrayen med hjälp av wordindex så att man får ett ord som man kan sen gissa.
            /// word = är ordet man ska gissa och här så sätts det till en char array så att man kan gissa på individuella bokstäver i ordet.
            /// running = denna är true då programmet ska köras
            /// correctAnswer = Här så gör den en array som har längden av answer variabeln som man ska hitta
            /// </summary>
            wordindex = number.Next(0, Words.Count);
            
            answer = Words[wordindex];

            word = answer.ToCharArray();

            running = true;

            char[] correctAnswer = new char[answer.Length];
            for (int i = 0; i < correctAnswer.Length; i++) // För längden av correctAnswer så lägger den in en _ på i indexen
            {
                correctAnswer[i] = '_';
            }

            while (running)
            {
                HangManArt(wrongGuess.Count); // Skriver ut en målning för att illustrera den klassiska hangman
            Nothing:
                if (wrongGuess.Count == art.Length - 1)// Hår så koller den så att man inte har gissat för många gånger
                {

                    return;
                }

                Console.WriteLine("Guesses");
                foreach (char c in wrongGuess)// kollar genom wrongGuess hor printar ut de bokstäver som existerar i listan
                {
                    Console.Write(c + " ");
                }
                Console.WriteLine(" ");
                Console.WriteLine();
                for (int i = 0; i < correctAnswer.Length; i++)// kollar genom correctAnswer och kollar på varje index i listan och printar ut vad som står i indexen och sätter ett space
                {
                    Console.Write(correctAnswer[i] + " ");
                }
                Console.WriteLine();
                string guess = "";// skapar en string som heter guess som används för att ta in en gissning. Den är en string för att man ska kunna gissa på hela ordet
                try
                {
                    guess = Console.ReadLine(); // sätter värdet på guess till det man skriver in
                    Console.Clear();// clearar konsolen

                }
                catch{ } // om det blir en error så fångar programmet det och ignorerar det så att man kan fortsätta spela
                if (guess == "")// catch fångar errorn så att den inte krashar när man klickar bara enter men correctAnswer[i] = word[i]; krashar programmet senare så fixade en så att den går till toppen av loopen om man skriver in bara enter
                {
                    goto Nothing;
                }
                if (guess == " ") // här så gör den så att man får försöka igen om man skriver in bara ett space
                {
                    Console.WriteLine("Try again!");
                    goto Nothing; // går till starten av While loopen
                }


                if (guess == answer) // Här så koller den hela ordet för att se om man gissade hela ordet rätt
                {
                    Console.WriteLine("You got it right!");
                    running = false; // While loopen stoppas
                    won = true; // won booleanen sätts till true så att man kommer in i en if sats där man kommer in i PlayAgain metoden
                }

                bool added = false; // skapar en bool som kommer användas för att kolla om bokstaven som man gissat är korrekt eller inte
                for (int i = 0; i < word.Length; i++)// gör x många iterationer beroende på längden av ordet
                {
                    if (word[i] == guess[0])// kollar om bokstaven i ordet på indexen i är samma som första bokstaven av ordet man gissat eller karktären man gissat
                    {
                        correctAnswer[i] = word[i]; // om den är samma så sätts det in i correctAnswer på samma index som den sitter i i word arrayen så att man innan man gissar igen ser vart det ska sitta
                        if (!correctGuess.Contains(guess[0])) // om bokstaven man gissat inte existerar i correctGuess så sätts det in och added blir true
                        {
                            correctGuess.Add(word[i]);
                            added = true;
                        }
                    }

                }

                if (!added)// om added är true så sätts inte bokstaven in i wrong Guess
                {
                    if (!wrongGuess.Contains(guess[0]))
                        wrongGuess.Add(guess[0]);

                }

                string word2 = new string(correctAnswer);// här så konverterar den correctAnswer arrayen till en string

                if (answer == word2)// kollar om ordet man ska hitta är samma som det man gissat i bokstäver istället för hela ordet på en gång
                {
                    Console.WriteLine("You got it right!");
                    running = false;
                    won = true;
                }

                



            }
        }
        public static void OwnGame()
        {
            // OwnGame är exakt likadan som Game förutom att man väljer sitt egna ord 

            Console.WriteLine("Write what word you want your friend/friends to guess.");
            answer = Console.ReadLine();
            Console.Clear();
            word = answer.ToCharArray();

            running = true;

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
            NoDelete();// går in i metoden som kollar om listan i .json filen har ett ord eller mindre annars och då kan man inte ta bort ord innan man lagt till mer
            if (!Exists)
            {
                Console.WriteLine("You can't delete your only word please add more before you delete");
                return;
            }
            #region Remove
            Console.WriteLine("Write what word you want to delete:");
            // 1
            string existing = File.ReadAllText("words.json");
            Console.WriteLine(existing);
            string newWord = Console.ReadLine();
            Console.Clear();
            // 1
            // från 1 till 1 så printar den hela listan av ord och tar in en variabel
            // 2
            Words.Remove(newWord.ToLower());
            CustomWords newWords = new CustomWords();
            newWords.words = Words;
            String insertedword = JsonConvert.SerializeObject(newWords);
            File.WriteAllText("words.json", insertedword);
            // 2
            // från 2 till 2 så tar den variabeln den fått av spelaren och om det är ett ord som inte existerar i listan ändras inget.
            Console.WriteLine("Do you want to delete another word?");
FaultyAnswer:
            Console.WriteLine("yes or no");
            YoN = Console.ReadLine(); //läser in variabel 
            Console.Clear();
            #endregion
            if (YoN.ToLower() == "yes")
            {
                goto DelAgain; // om man vill ta bort ett till ord så går den till toppen av metoden där den kollar om man kan ta bort ett ord eller inte i metoden DelAgain
            }
            else if (YoN.ToLower() == "no")// om man inte vill ta bort igen så kollar den om man vill spela igen
            {
                Console.WriteLine("Do you want to play?");
incorrectAnswer:
                Console.WriteLine("Yes or no");
                YoN = Console.ReadLine(); //läser in variabel
                Console.Clear();
                if (YoN.ToLower() == "yes") // om YoN är yes så sätts Play variabeln till true. Detta är för att när den kommer ut metoden så finns en if som skickar dig till starten av programmet igen
                {
                    Play = true;
                }
                else if (YoN.ToLower() == "no") // om YoN är no så stoppar den hela programmet genom att sätta Play till false
                {
                    Play = false;
                    Console.Clear();
                }
                else// om YoN inte är yes/no så frågar den igen
                {
                    goto incorrectAnswer;
                }
            }
            else// om YoN inte är yes/no så frågar den igen
            {
                Console.WriteLine("Try Again!");
                goto FaultyAnswer;
            }
        }
        public static void Add()
        {
        AddAgain:
            CustomWords oldWords = null; // Sätter owlWords till ingenting
            if (File.Exists("words.json"))// gör så att oldWords innehåller allt i word.json filen
            {
                string fileContent = File.ReadAllText("words.json");
                oldWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
            }

            Console.WriteLine("Write what word you want to add:");
            string existing = File.ReadAllText("words.json"); // låser in words.json och gör så att existing printar ut hela listan
FaultyWord:
            Console.WriteLine(existing);
            string newWord = Console.ReadLine();
            Console.Clear();
            if (newWord == "") // båda dessa if kollar så att man inte lägger till något som kommer vara nästan omöjligt att gissa
            {
                Console.Clear();
                Console.WriteLine("Must be a word!");
                goto FaultyWord;
            }
            else // kollar igenom hela ordet så att det inte är några mellanrum mitt i ordet.
            {
                for (int i = 0; i < newWord.Length; i++) 
                {
                    if (newWord[i] == ' ')
                    {
                        Console.Clear();
                        Console.WriteLine("Please don't use spaces!");
                        goto FaultyWord;
                    }
                }
            }
            for (int i = 0; i < Words.Count; i++)// kollar genom alla ord som finns i listan och kollar så att man inte lägger till samma ord två gånger
            {
                if (Words[i] == newWord)
                {
                    Console.Clear();
                    Console.WriteLine("Already existing word!");
                    goto FaultyWord;
                }
            }
            #region addingword
            Console.Clear();
            Words.Add(newWord.ToLower()); // gör så att ordet man vill lägga in är i små bokstäver så man inte behöver gissa med stora bokstäver
            // från 1 till 1 så lägger den till det nya ordet i den redan existerande listan av ord
            // 1
            oldWords.words.Add(newWord); 
            String insertedword = JsonConvert.SerializeObject(oldWords);
            File.WriteAllText("words.json", insertedword);
            // 1
            Console.WriteLine("Do you want to add another word?");
        FaultyAnswer:
            Console.WriteLine("yes or no");
            YoN = Console.ReadLine();
            Console.Clear();
            #endregion
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
                Console.Clear();
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
            // kollar om man vill lägga till mera ord och om man inte vill så kollar den om man vill spela igen där den sätter play boolean till true om man vill annars till false
        }
        public static void PlayAgain() 
        {
            // metoden frågar om man vill köra igen när man vunnit och om man säger jag så gör den listorna med fel och rätt gissningar till nya rena listor annars sätter den allt till false och så stoppas spelet
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
            // exakt samma som PlayAgain men när du forlorar
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
            // kollar så att det finns mer än 0 ord i listan och gör placeholder listan till den listan om det är mer än 0 i listan
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
            // kollar om listan existerar så att man kan edita den när man vill deleta.
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
            // kollar så att listan har mer än 1 ord innan man deletar och om den har 1 eller mindre så tillåter den dig inte att deleta ord
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
        #endregion
    }
}