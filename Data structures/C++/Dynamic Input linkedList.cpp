#include <iostream>
using namespace std;

class Node
{
    public:
    int data;
    Node *next;
};

main() {
    Node *temp = new Node();
    Node *first = NULL;

    int n;

    while(true)
    {//***
        cin >> n;
        if(n < 0)
            break;

        else {
            if(first == NULL) {
                first = new Node();
                first->data = n;
                first->next = NULL;
            }
            else {
                for(temp = first; temp->next != NULL; temp = temp->next){

                }
                temp->next = new Node;
                temp->next->data = n;
                temp->next->next = NULL;

            }
        }
    }//***

    if(first != NULL) {
        for(temp = first; temp != NULL; temp = temp->next) {
            cout << temp->data << "\t";
        }
    }
}
