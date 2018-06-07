bool checkPalindrome(char *inputString) {
    int l = 0;
    int h = strlen(inputString) - 1;
    while (h > l)
    {
        if (inputString[l++] != inputString[h--])
        {
            printf("%s is not a palindrome", inputString);
            return false;
        }
    }
    
    printf("%s is a palindrome", inputString);
    return true;
}