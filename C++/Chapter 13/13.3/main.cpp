/*Question 13.3 How do virtual functions work in C++?*/

/*Answer:A virtual function depends on a "viable" or "Virtual Table." If any function of a class is declared to be virlual, a viable is conslrucled which slores addresses of the virtual func- tions of this class. The compiler also adds a hidden vptr variable in all such classes which points to the viable of that class. If a virtual function is not overridden in the derived class, the viable of Ihe derived class slores the address of the function in ils parenl class. The viable is used to resolve the address of Ihe funclion when Ihe virtual funclion is called. Dynamic binding in C++ is performed Ihrough Ihe viable mechanism.
 Thus, when we assign Ihe derived class objecl lo Ihe base class pointer, Ihe vptr vari- able poinls lo Ihe viable of Ihe derived class. This assignmenl ensures lhat the most derived virtual function gels called.*/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class Shape{
public:
    int edge_length;
    virtual int circumference () {
        cout<<"Circumference of Base Class\n";
        return 0;
    }
};
class Triangle: public Shape{
public:
    int circumference () {
        cout<<"Circumference of Triangle Class\n";
        return 3 * edge_length;
    }
};
int main(){
    Shape *x = new Shape();
    x->circumference(); // prints “Circumference of Base Class”
    Shape *y = new Triangle();
    y->circumference(); // prints “Circumference of Triangle Class”
    return 0;
}
