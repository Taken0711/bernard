from glob import *
import re

def extract_effect():
	# WordNet words
	effect1= open("effectwordnet/EffectWordNet.tff").read()
	effect2= open("effectwordnet/goldStandard.tff").read()
	effect = effect1 + effect2
	res = open("effects.txt", "w")
	for line in effect.split("\n"):
		res.write(" ".join(line.split("\t")[1:3])+"\n")
	#cs.uic.edu words
	positive = open("positive-words.txt").read()
	for line in positive.split("\n"):
		if (line.startswith(";")):
			continue
		res.write("+Effect "+line+"\n")
		
	negative = open("negative-words.txt").read()
	for line in negative.split("\n"):
		if (line.startswith(";")):
				continue
		res.write("-Effect "+line+"\n")
	
	res.close()
	
	
	
def create_map():
	map = {"+Effect": [], "Null": [], "-Effect": []}
	dict = {}
	for f in glob("dict/data.*"):
		for line in f:
			m = re.search("(\d{8}) \d* . \d* ([^ ]*) .*", line)
			if m != None:
				dict[m.group(0)] = m.group(1)
	effect = open("effects.txt")
	for line in effect:
		print(line)
		m = re.search("(\d{8}) (\+Effect|-Effect|Null) ([^ ]*)", line)
		map[m.group(1)].append(dict[m.group(0)])
		map[m.group(1)].extend(m.group(2).split(","))
	print(map)
		

def main():
	extract_effect()

main()