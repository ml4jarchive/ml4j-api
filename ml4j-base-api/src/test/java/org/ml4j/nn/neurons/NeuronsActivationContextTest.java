package org.ml4j.nn.neurons;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.ml4j.MatrixFactory;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NeuronsActivationContextTest {

	@Mock
	private NeuronsActivationContext neuronsActivationContext;
	
	@Mock
	private MatrixFactory mockMatrixFactory;
	
	@Mock
	private InheritableThreadLocal<MatrixFactory> mockThreadLocalMatrixFactory;
	
	@Mock
	private InheritableThreadLocal<Boolean> mockThreadLocalIsTrainingContext;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(neuronsActivationContext.getMatrixFactory()).thenCallRealMethod();
		Mockito.when(neuronsActivationContext.isTrainingContext()).thenCallRealMethod();
	}
	
	@Test
	public void testGetMatrixFactoryWhenThreadLocalMatrixFactorySetAndMatrixFactorySet() {
		
		Mockito.when(mockThreadLocalMatrixFactory.get()).thenReturn(mockMatrixFactory);
		
		Mockito.when(neuronsActivationContext.getThreadLocalMatrixFactory()).thenReturn(mockThreadLocalMatrixFactory);
		
		MatrixFactory matrixFactory = neuronsActivationContext.getMatrixFactory();
		
		Assert.assertNotNull(matrixFactory);
		
		Assert.assertEquals(mockMatrixFactory, matrixFactory);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testGetMatrixFactoryWhenThreadLocalMatrixFactorySetAndMatrixFactoryNotSet() {
				
		Mockito.when(neuronsActivationContext.getThreadLocalMatrixFactory()).thenReturn(mockThreadLocalMatrixFactory);
		
		neuronsActivationContext.getMatrixFactory();
		
	}
	
	@Test(expected=IllegalStateException.class)
	public void testGetMatrixFactoryWhenThreadLocalMatrixFactoryNotSet() {					
		neuronsActivationContext.getMatrixFactory();	
	}
	
	@Test
	public void testIsTrainingContextWhenThreadLocalIsTrainingContextSetAndIsTrainingContextSetToTrue() {
		
		Mockito.when(mockThreadLocalIsTrainingContext.get()).thenReturn(true);
		
		Mockito.when(neuronsActivationContext.getThreadLocalIsTrainingContext()).thenReturn(mockThreadLocalIsTrainingContext);
		
		boolean isTrainingContext = neuronsActivationContext.isTrainingContext();
		
		Assert.assertTrue(isTrainingContext);
			
	}
	
	@Test
	public void testIsTrainingContextWhenThreadLocalIsTrainingContextSetAndIsTrainingContextSetToFalse() {
		
		Mockito.when(mockThreadLocalIsTrainingContext.get()).thenReturn(false);
		
		Mockito.when(neuronsActivationContext.getThreadLocalIsTrainingContext()).thenReturn(mockThreadLocalIsTrainingContext);
		
		boolean isTrainingContext = neuronsActivationContext.isTrainingContext();
		
		Assert.assertFalse(isTrainingContext);
			
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIsTrainingContextWhenThreadLocalIsTrainingContextSetAndIsTrainingContextSetToNull() {
		
		Mockito.when(mockThreadLocalIsTrainingContext.get()).thenReturn(null);
		
		Mockito.when(neuronsActivationContext.getThreadLocalIsTrainingContext()).thenReturn(mockThreadLocalIsTrainingContext);
		
		neuronsActivationContext.isTrainingContext();			
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIsTrainingContextWhenThreadLocalIsTrainingContextNotSet() {				
		neuronsActivationContext.isTrainingContext();			
	}


}
