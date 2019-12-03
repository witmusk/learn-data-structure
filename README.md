# 本科学的已经几乎全部还给老师了，重新学习下。
# Started At 20191202

1. ArrayList 
扩容： defaultCapacity=10; 每次扩容为newCapacity=oldCapacity+(oldCapacity>>1);max(newCapacity,minCapacityRequired); 注意长度溢出；
有个点，大数运算后比较大小，不要用aBigInt>anotherBigInt，要用aBigInt-anotherBigInt>0，因为可能溢出为负数。