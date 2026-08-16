**TIME COMPLEXITY**
describes how the number of operations a program performs scales as the input increases.

**`Big-O Notation`**
Complexity is written as O(f(n)), where `n` is the size of the input.

Rules:
1. Drop constant factors

O(3n) → O(n).
O(n/2) → O(n).

A program that does 3 operations per element and one that does 1 operation per element both scale the same way. The constant matters for real-world speed but not for the growth classification.

2. Keep the fastest-growing term

O(n² + n + 100) → O(n²).

When n = 1000, the n² term is 1,000,000 and the n term is 1,000. The smaller terms become *irrelevant* as n grows.

**`Complexity Classes`**
Ordered from fastest to slowest growth.

| Notation  | Name          | What it looks like in code          | n = 1,000  | n = 1,000,000 |
|---        |---            |---                                  |---         |---            |
| O(1)      | Constant      | A fixed formula, no loops over input| 1          | 1             |
| O(log n)  | Logarithmic   | Binary search; halving each step    | ~10        | ~20           |
| O(n)      | Linear        | One loop over the input             | 1,000      | 1,000,000     |
| O(n log n)| Linearithmic  | Sorting                             | ~10,000    | ~20,000,000   |
| O(n²)     | Quadratic     | Nested loop over the input          | 1,000,000  | 10¹² ❌       |
| O(n³)     | Cubic         | Triple nested loop                  | 10⁹ ❌      | ❌           |
| O(2ⁿ)     | Exponential   | Trying every subset                 | ❌          | ❌           |
| O(n!)     | Factorial     | Trying every permutation            | ❌          | ❌           |

❌ means "will not finish in any contest time limit."

**`Time Budgeting`**
Roughly 10⁸ simple operations per second.

USACO time limits are typically 2 seconds for Java.

n = 100,000 with O(n²) → 10¹⁰ operations → slow.
n = 100,000 with O(n log n) → ~1.7 million → comfortable.
n = 1,000 with O(n²) → 1 million → fine.

**`Reading Constraints`**
The constraint tells the intended complexity.


| If n is up to...  | The intended solution is probably... |
|---                |---                                   |
| 10–20             | O(2ⁿ) — exponential, try all subsets |
| ~100              | O(n³) — triple loop is fine          |
| ~1,000–5,000      | O(n²) — nested loop is fine          |
| ~10⁵–10⁶          | O(n log n) — sorting, or O(n)        |
| ~10⁷–10⁹          | O(n), O(log n), or O(1) — a formula  |

**`Calculating from Code`**
1. Sequential blocks
   a.) add
   b.) keep the max

```java
for (int i = 0; i < n; i++) { ... }   // O(n)
for (int i = 0; i < n; i++) { ... }   // O(n)
// Total: O(n) + O(n) = O(2n) = O(n)
```

2. Nested loops — multiply

```java
for (int i = 0; i < n; i++) {         // runs n times
   for (int j = 0; j < n; j++) {     // runs n times, for each i
       ...                           // O(1) inside
   }
}
// Total: O(n × n) = O(n²)
```

3. Nested loops of different sizes — multiply the actual sizes

```java
for (int i = 0; i < n; i++) {
   for (int j = 0; j < m; j++) { ... }
}
// Total: O(n × m) — NOT O(n²)
```

A loop over a 2000 × 2000 grid is O(W × H) = 4 million — fine. It is not "quadratic in the input size," because the input was only 12 integers.

4. Loops that shrink — often logarithmic

```java
while (n > 0) { n /= 2; }   // O(log n)
```
Halving reaches 1 in ~log₂(n) steps. For n = 1,000,000, that's 20 steps. Logs are super cheap.