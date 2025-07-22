export function swap<K>(array: K[], index1: number, index2: number): K[] {
  if (index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
    throw new Error('Index out of bounds.');
  }

  const newArray = [...array];
  const temp = newArray[index1];
  newArray[index1] = newArray[index2];
  newArray[index2] = temp;
  
  return newArray;
}
