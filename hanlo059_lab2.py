class Zillion:
    def __init__(self, digits):
        self.digits = []
        for i in digits:             # checks if there are digits in the list
            if i >= '0' and i <= '9':
                self.digits += [int(i)]
            elif i == " " or i == ",":
                pass
            else:
                raise RuntimeError
            

        if len(self.digits) == 0:
            raise RuntimeError("Empty String")
       


    def isZero(self): # checks if the list is zero
        l=0
        ifZero = True
        while l < len(self.digits):
            if (int(self.digits[l]) != 0):
                ifZero = False
            l += 1
        return ifZero
    
    def increment(self): #increments number in the list by 1
      l = len(self.digits) - 1
      allNines = True
      while(l >= 0):
        if(self.digits[l] == 9):
          self.digits[l] = 0
        else:
          allNines = False
          self.digits[l] = self.digits[l] + 1
          break
        l-=1

      if(allNines):
        self.digits[0] = 1
        self.digits += [0]

    def toString(self): # turns the list into a string
        i = 0
        newString = ''
        while i < len(self.digits):
            newString += str(self.digits[i])
            i += 1
        return newString



try:
  z = Zillion('')
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.
