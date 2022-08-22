from multiprocessing import Pool
import multiprocessing as m

def jc(num):
    print(m.current_process().pid,"run------",str(num))
    
if __name__ == '__main__':
    pool=Pool(m.cpu_count())
    for y in range(10):
        pool.apply(jc,args=(y,)) #同步
    pool.close()
    pool.join()