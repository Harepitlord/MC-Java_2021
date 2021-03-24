// A program which checks whether the given string is in the long string

package level2;

import java.util.Scanner;

public class findWordString {
    private static final String str = """
            The basic model for Turing
            machines (TM), Turing recognizable (recursively enumerable) and Turing-decidable (recursive)
            languages and their closure properties, variants of Turing machines, nondeterministic TMs and
            equivalence with deterministic TMs, unrestricted grammars and equivalence with Turing machines,
            TMs as enumerators. Undecidability: Church-Turing thesis, universal Turing machine, the universal
            and diagonalization languages, reduction between languages and Rice s theorem, undecidable
            problems about languages. Basic Introduction to Complexity: Introductory ideas on Time complexity of
            deterministic and nondeterministic Turing machines, P and NP, NP- completeness, Cook’s Theorem,
            other NP -Complete problems.""";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        if (!str.contains(s)) {
            System.out.println("The string not found");
        } else {
            System.out.println("The String found");
        }
    }
}
