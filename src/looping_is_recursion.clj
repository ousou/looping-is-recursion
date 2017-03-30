(ns looping-is-recursion)

(defn power [base exp]
  (let [helper (fn [acc base exp]
                 (if (zero? exp)
                   acc
                   (recur (* acc base) base (dec exp))))]
    (helper 1 base exp)))

(defn singleton? [coll]
  (and (not (empty? coll)) (empty? (rest coll))))

(defn last-element [a-seq]
  (let [helper (fn [a-seq]
                (if (or (empty? a-seq) (singleton? a-seq))
                  (first a-seq)
                  (recur (rest a-seq))))]
  (helper a-seq)))

(defn seq= [seq1 seq2]
  ":(")

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

