public class Sorter {
    public LinkedList Radix(LinkedList list) {
        LinkedList[] bins = new LinkedList[10];;
        LinkedList.ListNode tempNode;
        Object value;
        int valueAsInt, digits, binidx;
        String valueAsString;

        for (int i = 1; i <= list.maxLength().length(); i++) {
            for (int j = 0; j < 10; j++) {
                bins[j] = new LinkedList();
            }
            
            tempNode = list.head;

            while (tempNode != null) {
                value = tempNode.getValue();
                valueAsInt = (int)value;
                valueAsString = String.valueOf(valueAsInt);
                digits = valueAsString.length();
                binidx = digits < i ? 0 : Character.getNumericValue(valueAsString.charAt(digits - i));
                bins[binidx].addToEnd(value);
                tempNode = tempNode.getNext();
            }

            list = new LinkedList();

            for (LinkedList bin: bins) {
                tempNode = bin.head;

                while (tempNode != null) {
                    list.addToEnd(tempNode.getValue());
                    tempNode = tempNode.getNext();
                }
            }
        }

        return list;
    }
}

