class xorNode {
    int value;
    //This both should be a function of some sort
    //Since it has to have the xor operator in it
    //Also have to keep the reference to the prior node stored in it
    bool both;
    public:
    void add(xorNode);
    *xorNode get(int);
}

void xorNode::add(xorNode nodeToAdd){
    //Needs to remake the both function/field by taking the value from it and placing it into a new one
    //With the added node afterward
    //Could just run the both function for the previous node and then use the memory reference when
    //Making the new function
}

void xorNode::get(int index){
    if(value == index){
        return this;
    } else if (index < value){

    } else {

    }
}