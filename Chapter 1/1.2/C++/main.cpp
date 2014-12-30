/*Question 1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null- terminated string. */

#include <iostream>
#include <string>
using namespace std;


void swap(char &a, char &b)
{
    char c = a;
    a = b;
    b = c;
}

void reverse(char * str)
{
    if(str == NULL)
        return;
    char * p;
    char * q;
    p=str,q=str;
    
    while (*q != '\0')
        q++;
    q--;
    while (p<q)
        swap(*p++, *q--);
}

int main() {
    char s[] = "abcdefgh";
    reverse(s);
    cout<<s<<endl;
    return 0;
}
