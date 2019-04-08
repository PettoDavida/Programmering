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

        static string answer;

        static char[] word;
        static List<char> correctGuess = new List<char>();
        static List<char> wrongGuess = new List<char>();
        static bool running;

        static void Main(string[] args)
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


                char guess = Console.ReadLine()[0];



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
                HangManArt(wrongGuess.Count);
            }

            
        }
        public static void HangManArt(int j)
        {
            if (j < art.Length)
            {
                Console.WriteLine(art[j]);
            }

        }
       
       

           


            }
        }
    