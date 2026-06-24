import threading
import time

class Logger:
  _instance = None
  _lock = threading.Lock()

  def __init__(self):
    time.sleep(1)
    print("Logger initialized")
    if Logger._instance is not None:
      raise Exception("Logger Existed Already.")
    Logger._instance = self

  @classmethod
  def get_logger(cls):
    if cls._instance is None:
      with cls._lock:
        print("lock obtained.....")
        if cls._instance is None:
          print("instance created")
          cls._instance = Logger()
    return cls._instance

  def log(self,msg):
    print(f"[LOG]: {msg}")


# -----Client Code---------
def worker(name):
  logger = Logger.get_logger()
  logger.log(f"Worker {name} is logging")

threads = []
for i in range(5):
  t = threading.Thread(target=worker,args =(i,))
  threads.append(t)
  t.start()

for t in threads:
  t.join()

non_thread = Logger.get_logger()
non_thread.log("logging non thread object")