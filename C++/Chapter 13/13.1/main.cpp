/*Question 13.1 Write a method to print the last K lines of an input file using C++.*/

/*Answer: we use a array of string to hold every K lines of the file.
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

void printLastKLines(ifstream &fin, int k){
    string *line = new string[k];
    int lines = 0;
    string tmp;
    while(getline(fin, tmp)){
        line[lines%k] = tmp;
        ++lines;
    }
    int start, cnt;
    if(lines < k){
        start = 0;
        cnt = lines;
    }
    else{
        start = lines%k;
        cnt = k;
    }
    for(int i=0; i<cnt; ++i)
        cout<<line[(start+i)%k]<<endl;
    
    delete []line;
}
int main(){
    ifstream fin("13.1.in");
    int k = 4;
    printLastKLines(fin, k);
    fin.close();
    return 0;
}
