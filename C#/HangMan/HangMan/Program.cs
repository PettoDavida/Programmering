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
        static List<char> correctGuess = new List<char>();
        static List<char> wrongGuess = new List<char>();
        static bool running;

        static void Main(string[] args)
        {
            if (File.Exists("words.json"))
            {
                string fileContent = File.ReadAllText("words.json");
                CustomWords newWords = JsonConvert.DeserializeObject<CustomWords>(fileContent);
                Words = newWords.words;
            }

            Console.WriteLine("Do you want to play or add custom words?");
            Console.WriteLine("It is recommended to add words if it is your first time!");
            ForbiddenMagic4:
            Console.WriteLine("If you want to add words write (add)");
            Console.WriteLine("If you want to play write (play)");
            PlayorAdd = Console.ReadLine();

            if (PlayorAdd.ToLower() == "play")
            {
                goto ForbiddenMagic;
            }
            else if(PlayorAdd.ToLower() == "add")
            {
                ForbiddenMagic6:
                Console.WriteLine("Write what word you want to add:");
                string newWord = Console.ReadLine();
                Words.Add(newWord);
                CustomWords newWords = new CustomWords();
                newWords.words = Words;
                String insertedword = JsonConvert.SerializeObject(newWords);
                File.WriteAllText("words.json", insertedword);
                Console.WriteLine("Do you want to add another word?");
                ForbiddenMagic5:
                Console.WriteLine("yes or no");
                YoN = Console.ReadLine();
                if ( YoN.ToLower() == "yes")
                {
                    goto ForbiddenMagic6;
                }else if (YoN.ToLower() == "no")
                {
                    
                }
                else
                {
                    Console.WriteLine("Try Again!");
                    goto ForbiddenMagic5;
                }
            }
            else
            {
                Console.WriteLine("Please try again!");
                goto ForbiddenMagic4;
            }



        ForbiddenMagic:
            Game();

            if (wrongGuess.Count == art.Length - 1)
            {
                Console.WriteLine("You Lost!");
                Console.WriteLine("The answer was: " + answer);
                Console.WriteLine();
            ForbiddenMagic2:
                Console.WriteLine("Want to play again? Answer: yes or no");
                string yesorno = Console.ReadLine();

                if (yesorno.ToLower() == "yes")
                {
                    wrongGuess = new List<char>();
                    goto ForbiddenMagic;
                }
                else if (yesorno.ToLower() == "no")
                {
                    running = false;
                }
                else
                {
                    Console.WriteLine("Please try again!");
                    goto ForbiddenMagic2;
                }

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
        /// <summary>
        /// wordindex = skapar ett tal som är mellan 0 och så många ord som finns i arrayen med orden man ska gissa.
        /// </summary>
        public static void Game()
        {

            wordindex = number.Next(0, Words.Count);

            answer = Words[wordindex];

            word = answer.ToCharArray();

            running = true;

            Console.WriteLine(answer);

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
                for (int i = 0; i < word.Length; i++)
                {
                    if (correctGuess.Contains(word[i]))
                    {
                        Console.Write(word[i] + " ");
                    }
                    else
                    {
                        Console.Write("_ ");
                    }
                }
                Console.WriteLine();

                char guess = ' ';
                try
                {
                    guess = Console.ReadLine()[0];
                }
                catch (Exception e)
                {
                    goto Forbiddenmagic3;
                }


                bool added = false;
                for (int i = 0; i < word.Length; i++)
                {
                    if (word[i] == guess)
                    {
                        if (!correctGuess.Contains(guess))
                        {
                            correctGuess.Add(word[i]);
                            added = true;
                        }
                    }

                }

                if (!added)
                {
                    if (!wrongGuess.Contains(guess))
                        wrongGuess.Add(guess);

                }
            Forbiddenmagic3:
                HangManArt(wrongGuess.Count);


            }
        }
        
    }
}
