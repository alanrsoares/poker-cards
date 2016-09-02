(ns poker-cards.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [poker-cards.core-test]))

(doo-tests 'poker-cards.core-test)
