using System;
using System.Collections.Generic;


namespace HangMan
{

    class Program
    {
        static void Main(string[] args)
        {
            List<string> Words = new List<string> { "jesus", "owl", "peasant", "cupboard", "pizza", "buttplug", "farmer", };

            Random number = new Random();
            int wordindex = number.Next(0, Words.Count);

            string answer = Words[wordindex];

            char[] word = answer.ToCharArray();
            List<char> correctGuess = new List<char>();
            List<char> wrongGuess = new List<char>();
            bool running = true;

            Console.WriteLine(answer);

            while (running)
            {
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
            }


        }

    }
}