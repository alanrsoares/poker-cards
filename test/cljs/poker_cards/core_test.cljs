(ns poker-cards.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [poker-cards.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
