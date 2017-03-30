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
  (let [helper (fn [a-seq b-seq]
                (cond (and (empty? a-seq) (empty? b-seq)) true
                      (or (empty? a-seq) (empty? b-seq)) false
                      (= (first a-seq) (first b-seq)) (recur (rest a-seq) (rest b-seq))
                      :else false))]
  (helper seq1 seq2)))

(defn find-first-index [pred a-seq]
  (loop [seq1 a-seq
         index 0]
    (cond (empty? seq1) nil
          (pred (first seq1)) index
          :else (recur (rest seq1) (inc index)))))

(defn avg [a-seq]
  (loop [seq1 a-seq
         sum 0
         amount 0]
    (if (empty? seq1)
      (/ sum amount)
      (recur (rest seq1) (+ sum (first seq1)) (inc amount)))))

(defn toggle [a-set elem]
  (if (contains? a-set elem) (disj a-set elem) (conj a-set elem)))

(defn parity [a-seq]
  (loop [parity-set #{}
         seq1 a-seq]
    (if (empty? seq1)
      parity-set
      (recur (toggle parity-set (first seq1)) (rest seq1)))))

(defn fast-fibo [n]
  (loop [curr-n (dec (dec n))
         fib-n 1
         fib-nm1 0]
    (cond (zero? n) 0
          (<= curr-n 0) (+ fib-n fib-nm1)
          :else (recur (dec curr-n) (+ fib-n fib-nm1) fib-n))))

(defn cut-at-repetition [a-seq]
  [":("])

