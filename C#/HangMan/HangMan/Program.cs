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
        static List<string> Words = new List<string> { "jesus", "owl", "peasant", "cupboard", "pizza", "buttplug", "farmer", };

        static Random number = new Random();
        static int wordindex;
        static string PlayorAdd = "";

        static string answer;
        static string YoN;

        static char[] word;
        static List<char> correctAnswer = new List<char>();
        static List<char> correctGuess = new List<char>();
        static List<char> wrongGuess = new List<char>();
        static bool running;
        static bool won = false;

        static void Main(string[] args)
        {
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                CustomWords newWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
                Words = newWords.words;
            }

            Console.WriteLine("Do you want to play or add custom words?");
            Console.WriteLine("You can also choose your own word if you want to play with a friend!");
            Console.WriteLine("It is recommended to add words if it is your first time!");
            Thread.Sleep(2000);
            Console.Clear();
Start:
            Console.WriteLine("If you want to add words write (add)");
            Console.WriteLine("If you want to delete words write (delete)");
            Console.WriteLine("If you want to play write (play)");
            Console.WriteLine("If you want to choose your own word write(own)");
            Console.WriteLine("If you want to choose stop write (stop)");

            PlayorAdd = Console.ReadLine();
            Console.Clear();
            if (PlayorAdd.ToLower() == "play")
            {
                Game();
            }
            else if (PlayorAdd.ToLower() == "add")
            {
                Add();
                goto Start;
            }
            else if (PlayorAdd.ToLower() == "delete")
            {
                Delete();
                goto Start;
            }
            else if (PlayorAdd.ToLower() == "own")
            {
                OwnGame();   
            }
            else if (PlayorAdd.ToLower() == "stop")
            {

            }
            else
            {
                Console.WriteLine("Please try again!");
                goto Start;
            }

            if (wrongGuess.Count == art.Length - 1)
            {
                Lost();
                if (running)
                {
                    goto Start;
                }      
            }
PlayGame:

            if (won)
            {

                PlayAgain();
            }
            if (won)
            {
                goto PlayGame;

            }

            Console.WriteLine("Program stops in 5 seconds");
            Thread.Sleep(5000);
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

                if (guess == "")
                {
                    goto Forbiddenmagic3;
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

Forbiddenmagic3:
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

                if (guess =="")
                {
                    goto Forbiddenmagic3;
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

Forbiddenmagic3:
                HangManArt(wrongGuess.Count);
            }

        }
        public static void Delete()
        {
        DelAgain:
            Console.WriteLine("Write what word you want to delete:");
            Console.WriteLine();
            string newWord = Console.ReadLine();
            Console.Clear();
            Words.Remove(newWord);
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
            Console.WriteLine("Write what word you want to add:");
            string newWord = Console.ReadLine();
            Console.Clear();
            Words.Add(newWord);
            CustomWords newWords = new CustomWords();
            newWords.words = Words;
            String insertedword = JsonConvert.SerializeObject(newWords);
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
            string yesorno = Console.ReadLine();
            Console.Clear();

            if (yesorno.ToLower() == "yes")
            {

                correctGuess = new List<char>();
                wrongGuess = new List<char>();
                Game();
            }
            else if (yesorno.ToLower() == "no")
            {
                running = false;
                won = false;
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
            string yesorno = Console.ReadLine();
            Console.Clear();

            if (yesorno.ToLower() == "yes")
            {
                correctGuess = new List<char>();
                wrongGuess = new List<char>();
                running = true;
            }
            else if (yesorno.ToLower() == "no")
            {
                running = false;

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
    }
}
